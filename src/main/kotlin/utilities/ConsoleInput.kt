package utilities

import model.Data
import utilities.validators.Validator
import java.io.IOException
import java.util.*

class ConsoleInput<V>(private val prompt: String, private val validator: Validator<V>,private val data: Data) {
    fun enterValue(): V {
        var input: V? = null
        while (input == null) {
            println(prompt)
            val stringInput = readLine()!!
            try {
                input = validator.validate(stringInput,data)
            } catch (e: Exception) {
                println("Invalid input try again:")
            }
        }
        return input
    }
}