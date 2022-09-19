package fr.sadok.fizzbuzz.domain.use_case

data class ValidationResult(
    val success: Boolean,
    val message: String? = null
)