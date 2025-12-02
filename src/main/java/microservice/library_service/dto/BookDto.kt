package microservice.library_service.dto

data class BookDto @JvmOverloads constructor(val bookId: BookIdDto? = null,
    val title: String? = "",
    val year: String? = "",
    val author: String? = "",
    val pressName: String? = "")
