package utilities.validators

import model.Data
import java.lang.RuntimeException


interface Validator<V> {
    @Throws(Exception::class)
    fun validate(string: String,data: Data): V
}