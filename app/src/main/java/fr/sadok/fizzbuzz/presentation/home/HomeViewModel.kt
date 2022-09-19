package fr.sadok.fizzbuzz.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.sadok.fizzbuzz.domain.entity.FizzBuzzEntity
import fr.sadok.fizzbuzz.domain.use_case.ValidateLimit
import fr.sadok.fizzbuzz.domain.use_case.ValidateNumber
import fr.sadok.fizzbuzz.domain.use_case.ValidateText

class HomeViewModel(
    private val validateNumber: ValidateNumber = ValidateNumber(),
    private val validateLimit: ValidateLimit = ValidateLimit(),
    private val validateText: ValidateText = ValidateText()
) : ViewModel() {

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

    private val _goToResultScreen = MutableLiveData<FizzBuzzEntity?>()
    val goToResultScreen: LiveData<FizzBuzzEntity?>
        get() = _goToResultScreen

    init {
        _goToResultScreen.value = null
        resetErrorMessage()
    }

    fun validate(number1: String, number2: String, limit: String, text1: String, text2: String) {
        resetErrorMessage()

        _number1Error.value = validateNumber.execute(number1).message
        _number2Error.value = validateNumber.execute(number2).message
        _limitError.value = validateLimit.execute(limit).message
        _text1Error.value = validateText.execute(text1).message
        _text2Error.value = validateText.execute(text2).message
        if(isFormValid())
            _goToResultScreen.value = FizzBuzzEntity(
                number1.toInt(),
                number2.toInt(),
                limit.toInt(),
                text1,
                text2
            )

    }

    private fun isFormValid(): Boolean {
        return _number1Error.value.isNullOrEmpty() &&
                _number2Error.value.isNullOrEmpty() &&
                _limitError.value.isNullOrEmpty() &&
                _text1Error.value.isNullOrEmpty() &&
                _text2Error.value.isNullOrEmpty()

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