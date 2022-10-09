package utilities.validators

import model.Data
import model.MonthlyConsumption
import java.time.Month

class MonthlyConsumptionValidator: Validator<MonthlyConsumption>{

    override fun validate(string: String, data:Data): MonthlyConsumption {
        val strings = string.split(" ")
        val month = when (strings.get(0).substring(0..2).uppercase()){
            "JAN" -> Month.JANUARY
            "FEB" -> Month.FEBRUARY
            "MAR" -> Month.MARCH
            "APR" -> Month.APRIL
            "MAY" -> Month.MAY
            "JUN" -> Month.JUNE
            "JUL" -> Month.JULY
            "AUG" -> Month.AUGUST
            "SEP" -> Month.SEPTEMBER
            "OCT" -> Month.OCTOBER
            "NOV" -> Month.NOVEMBER
            "DEC" -> Month.DECEMBER
            else -> throw Exception("")
        }
        val year:Int
        if(strings[1].matches(Regex("([0-9]{4})"))){
            year =  strings[1].toInt()
        }
        else{
            throw Exception("")
        }

        return data.searchMonthlyConsumption(year,month)

    }

}