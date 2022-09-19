package fr.sadok.fizzbuzz.domain.use_case

import fr.sadok.fizzbuzz.domain.entity.FizzBuzzEntity
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class CalculateFizzBuzzTest {

    private lateinit var calculateFizzBuzz: CalculateFizzBuzz

    @Before
    fun setUp() {
        calculateFizzBuzz = CalculateFizzBuzz()
    }

    @Test
    fun `valid FizzBizz, returns success`() {
        val result = calculateFizzBuzz.execute(FizzBuzzEntity(1,2,3,"F","B"))

        assertEquals(result, listOf("F","FB","F"))
    }
}