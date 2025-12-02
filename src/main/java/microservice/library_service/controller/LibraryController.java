package microservice.library_service.controller;

import microservice.library_service.dto.AddBookRequest;
import microservice.library_service.dto.LibraryDto;
import microservice.library_service.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    private final LibraryService service;

    public LibraryController(LibraryService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id){
        return ResponseEntity.ok(service.getAllBooksInLibraryById(id));
    }

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary(){
        return ResponseEntity.ok(service.createLibrary());
    }

    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request){
        service.addBookToLibrary(request);
        return ResponseEntity.ok().build();
    }
}
