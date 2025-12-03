package microservice.library_service.dto

data class BookDto(
    val id: BookIdDto,
    val title: String,
    val bookYear: String,
    val author: String,
    val pressName: String)
