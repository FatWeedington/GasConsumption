package utilities.validators

import model.Data
import model.YearlyConsumption

//validator checks string input with regex and searches data object for secified year throws exeption if year is not found
class YearlyConsumptionValidator: Validator<YearlyConsumption>{

    override fun validate(string: String, data:Data): YearlyConsumption {
        val year:Int
            if (string.matches(Regex("([0-9]{4})"))) {
                year = string.toInt()
            } else {
                throw Exception("")
            }
            if(data.searchYearlyConsumption(year)!= null){
                return data.searchYearlyConsumption(year)!!
            }
            else {
                throw Exception("")
            }
    }
}