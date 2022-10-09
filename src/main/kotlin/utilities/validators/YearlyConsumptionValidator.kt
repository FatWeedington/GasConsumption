package utilities.validators

import model.Data
import model.MonthlyConsumption
import model.YearlyConsumption

class YearlyConsumptionValidator: Validator<YearlyConsumption>{

    override fun validate(string: String, data:Data): YearlyConsumption {
        val year:Int
            if (string.matches(Regex("([0-9]{4})"))) {
                year = string.toInt()
            } else {
                throw Exception("")
            }

            return data.searchYearlyConsumption(year)
    }
}