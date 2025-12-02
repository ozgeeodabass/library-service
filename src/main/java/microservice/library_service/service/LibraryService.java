package microservice.library_service.service;

import microservice.library_service.client.BookServiceClient;
import microservice.library_service.dto.AddBookRequest;
import microservice.library_service.dto.LibraryDto;
import microservice.library_service.exception.LibraryNotFoundException;
import microservice.library_service.model.Library;
import microservice.library_service.repository.LibraryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private final LibraryRepository repository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository repository, BookServiceClient bookServiceClient) {
        this.repository = repository;
        this.bookServiceClient = bookServiceClient;
    }

    public LibraryDto getAllBooksInLibraryById(String id){
        Library library = repository.findById(id)
                .orElseThrow(()-> new LibraryNotFoundException("Library not found by id: " + id));

        return new LibraryDto(library.getId(),
                library.getUserBook()
                        .stream()
                        .map(bookServiceClient::getBookById)
                        .map(ResponseEntity::getBody)
                        .collect(Collectors.toList()));
    }

    public LibraryDto createLibrary(){
        Library library = repository.save(new Library());
        return new LibraryDto(library.getId());
    }

    public void addBookToLibrary(AddBookRequest addBookRequest){
        String bookId = bookServiceClient.getBookByIsbn(addBookRequest.getIsbn()).getBody().getId();
        Library library= repository.findById(addBookRequest.getId())
                .orElseThrow(()-> new LibraryNotFoundException("Library not found by id: " + addBookRequest.getId()));
        library.getUserBook().add(bookId);
        repository.save(library);
    }

}
