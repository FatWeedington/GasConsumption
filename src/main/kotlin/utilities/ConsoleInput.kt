package utilities

import model.Data
import utilities.validators.Validator

//returns Object of given type (specific validator needed) based on user input via cli validated by a validator Object, prompt is used to display expected input
class ConsoleInput<V>(private val prompt: String, private val validator: Validator<V>,private val data: Data) {
    //Validates user input, resets cli if input is incorrect (Exception thrown by Validator)
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