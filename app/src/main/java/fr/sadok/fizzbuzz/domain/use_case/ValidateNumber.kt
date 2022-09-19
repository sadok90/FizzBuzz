package fr.sadok.fizzbuzz.domain.use_case

class ValidateNumber {

    fun execute(number: String) : ValidationResult {
        return  try {
            val numberInt = number.toInt()
            if(numberInt <= 0)
                ValidationResult(false,
                "number mast be grater than 0")
            else
                ValidationResult(true)
        } catch (e: NumberFormatException) {
            ValidationResult(false, "invalid number")
        }

    }
}