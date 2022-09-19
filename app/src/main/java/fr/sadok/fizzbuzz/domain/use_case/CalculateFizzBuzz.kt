package fr.sadok.fizzbuzz.domain.use_case

import fr.sadok.fizzbuzz.domain.entity.FizzBuzzEntity

class CalculateFizzBuzz {

    fun execute(fizzBuzzData: FizzBuzzEntity): ArrayList<String> {

        val result = arrayListOf<String>()
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

}