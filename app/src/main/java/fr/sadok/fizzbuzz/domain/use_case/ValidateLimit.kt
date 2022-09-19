package fr.sadok.fizzbuzz.domain.use_case

class ValidateLimit {

    fun execute(limitStr: String): ValidationResult {
        return try {
            val limit = limitStr.toInt()
            if(limit < 2) ValidationResult(false,"limit mast be grater than 2")
            else ValidationResult(true)
        } catch (e: NumberFormatException) {
            ValidationResult(false, "invalid number")
        }
    }
}