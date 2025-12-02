package microservice.library_service.repository;

import microservice.library_service.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,String> {
}
