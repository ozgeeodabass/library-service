package microservice.library_service.model

import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Library @JvmOverloads constructor(
    @Id
    @Column(name="library_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? ="",

    @ElementCollection
    val userBook: List<String> = ArrayList()
)
