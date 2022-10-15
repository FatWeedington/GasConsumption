package utilities.validators

import model.Data

//validator checks string input with regex and returns boolean value for defining unit while printing Consumption details on MonthlyConsumption Object
class UnitValidator: Validator<Boolean>{

    override fun validate(string: String, data:Data): Boolean {
        return  when (string){
            "m3" -> true
            "kWh" -> false
            else -> throw Exception("")
        }

    }

}