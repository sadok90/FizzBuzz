package fr.sadok.fizzbuzz.domain.use_case

class ValidateText {

    fun execute(text: String): ValidationResult {
        return when {
            text.isBlank() -> ValidationResult(false, "Text must be set")
            !text.any { it.isLetter() } ->
                ValidationResult(false,"Text must contain at least one letter")
            else -> ValidationResult(true)
        }
    }
}