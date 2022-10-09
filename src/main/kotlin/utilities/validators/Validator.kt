package utilities.validators

import model.Data
import java.lang.RuntimeException


//unites validator object to use them generically in ConsoleInput Objects throws Exception if Object cant be found
interface Validator<V> {
    @Throws(Exception::class)
    fun validate(string: String,data: Data): V
}