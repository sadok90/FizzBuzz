package fr.sadok.fizzbuzz.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.sadok.fizzbuzz.data.FizzBuzzData

class HomeViewModel : ViewModel() {

    private val _number1Error = MutableLiveData<String?>()
    val number1Error: LiveData<String?>
        get() = _number1Error
    private val _number2Error = MutableLiveData<String?>()
    val number2Error: LiveData<String?>
        get() = _number2Error
    private val _limitError = MutableLiveData<String?>()
    val limitError: LiveData<String?>
        get() = _limitError
    private val _text1Error = MutableLiveData<String?>()
    val text1Error: LiveData<String?>
        get() = _text1Error
    private val _text2Error = MutableLiveData<String?>()
    val text2Error: LiveData<String?>
        get() = _text2Error

    private val _goToResultScreen = MutableLiveData<FizzBuzzData?>()
    val goToResultScreen: LiveData<FizzBuzzData?>
        get() = _goToResultScreen

    init {
        _goToResultScreen.value = null
        resetErrorMessage()
    }

    fun validate(number1: String, number2: String, limit: String, text1: String, text2: String) {
        resetErrorMessage()

        _number1Error.value = validateNumber(number1, limit)
        _number2Error.value = validateNumber(number2, limit)
        _limitError.value = validateLimit(limit)
        _text1Error.value = validateText(text1, text2)
        _text2Error.value = validateText(text2, text1)
        if(isFormValid())
            _goToResultScreen.value = FizzBuzzData(number1.toInt(),
                number2.toInt(),
                text1,
                text2,
                limit.toInt())

    }

    private fun isFormValid(): Boolean {
        return _number1Error.value.isNullOrEmpty() &&
                _number2Error.value.isNullOrEmpty() &&
                _limitError.value.isNullOrEmpty() &&
                _text1Error.value.isNullOrEmpty() &&
                _text2Error.value.isNullOrEmpty()

    }
    private fun validateText(text1: String, text2: String): String? {
        return when {
            text1.isEmpty() -> "Text must be set"
            text1 == text2 -> "The tow text must be different"
            else -> null
        }
    }

    private fun validateLimit(limitStr: String): String? {
        return try {
            val limit = limitStr.toInt()
            if(limit < 2) "limit mast be grater than 2"
            else null
        } catch (e: Exception) {
            "limit invalid"
        }
    }

    private fun validateNumber(number: String, limit: String) : String? {
        return when {
                number.isEmpty() -> "number invalid"
                number.toInt() <= 0 -> "number mast be grater than 0"
                limit.isNotEmpty() && number.toInt() > limit.toInt() -> "number mast be grater than limit"
                else -> null
            }

    }

    private fun resetErrorMessage() {
        _number1Error.value = null
        _number2Error.value = null
        _limitError.value = null
        _text1Error.value = null
        _text2Error.value = null
    }

    fun clearNavigationData() {
        _goToResultScreen.value = null
    }

}