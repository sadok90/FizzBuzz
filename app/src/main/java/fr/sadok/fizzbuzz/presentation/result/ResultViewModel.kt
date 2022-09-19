package fr.sadok.fizzbuzz.presentation.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.sadok.fizzbuzz.domain.entity.FizzBuzzEntity
import fr.sadok.fizzbuzz.domain.use_case.CalculateFizzBuzz

class ResultViewModel(fizzBuzzData: FizzBuzzEntity,
                      calculateFizzBuzz: CalculateFizzBuzz = CalculateFizzBuzz()
) : ViewModel() {

    private val _resultList = MutableLiveData<ArrayList<String>>()
    val resultList: LiveData<ArrayList<String>>
        get() = _resultList

    init {
        _resultList.value = calculateFizzBuzz.execute(fizzBuzzData)
    }

    class Factory(private val fizzBuzzData: FizzBuzzEntity): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T = ResultViewModel(fizzBuzzData) as T
    }
}