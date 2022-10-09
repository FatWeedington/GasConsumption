package utilities.validators

import model.Data
import model.MonthlyConsumption
import java.time.Month

class UnitValidator: Validator<Boolean>{

    override fun validate(string: String, data:Data): Boolean {
        return  when (string){
            "m3" -> true
            "kWh" -> false
            else -> throw Exception("")
        }

    }

}