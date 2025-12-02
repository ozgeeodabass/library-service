package microservice.library_service.client;

import microservice.library_service.dto.BookDto;
import microservice.library_service.dto.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@FeignClient(name = "book-service", path = "/v1/book")
public interface BookServiceClient {

    @GetMapping("/isbn/{isbn}")
    ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn);

    @GetMapping("/id/{id}")
    ResponseEntity<BookDto> getBookById(@PathVariable String id);
}
