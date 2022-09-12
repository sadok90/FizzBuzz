package fr.sadok.fizzbuzz.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.sadok.fizzbuzz.data.FizzBuzzData

class ResultViewModel(fizzBuzzData: FizzBuzzData) : ViewModel() {

    private val _resultList = MutableLiveData<ArrayList<String>>()
    val resultList: LiveData<ArrayList<String>>
        get() = _resultList

    init {
        _resultList.value = calculate(fizzBuzzData)
    }

    private fun calculate(fizzBuzzData: FizzBuzzData): ArrayList<String>? {

        val result = ArrayList<String>()
        fizzBuzzData.apply {
            for (i in 1..limit) {
                when {
                    i % number1 == 0 && i % number2 == 0 -> result.add(text1+text2)
                    i % number1 == 0 -> result.add(text1)
                    i % number2 == 0 -> result.add(text2)
                    else -> result.add(i.toString())
                }
            }
        }
        return result
    }


    class Factory(private val fizzBuzzData: FizzBuzzData): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T = ResultViewModel(fizzBuzzData) as T
    }
}