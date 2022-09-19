package fr.sadok.fizzbuzz.domain.use_case

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ValidateNumberTest {

        private lateinit var validateNumber: ValidateNumber

        @Before
        fun setUp() {
            validateNumber = ValidateNumber()
        }

        @Test
        fun `empty number, returns error`() {
            val result = validateNumber.execute("")

            assertEquals(result.success, false)
        }

        @Test
        fun `invalid number, returns error`() {
            val result = validateNumber.execute("a")

            assertEquals(result.success, false)
        }

        @Test
        fun `valid number, returns success`() {
            val result = validateNumber.execute("11")

            assertEquals(result.success, true)
        }

}