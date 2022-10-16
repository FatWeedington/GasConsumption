package utilities.validators

import model.Data
import model.MonthlyConsumption
import java.time.Month

//validator checks string input e.g. March 2021 and searches the corresponding MonthlyConsumption Object stored in Data object for a specified Month in a specified Year
class MonthlyConsumptionValidator: Validator<MonthlyConsumption>{

    override fun validate(string: String, data:Data): MonthlyConsumption {
        val strings = string.split(" ")
        //Defines Month
        val month = when (strings[0].substring(0..2).uppercase()){
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
            else -> throw Exception("${strings[0]} is not a valid month")
        }
        //Defines Year
        val year:Int
        if(strings[1].matches(Regex("([0-9]{4})"))){
            year =  strings[1].toInt()
        }
        else{
            throw Exception("${strings[1]} does not match valid year e.g 2019")
        }
        //returns object if found in data object (Throws exeption if nothing found)
        if (data.searchMonthlyConsumption(year,month) == null){
            throw Exception("data for ${strings[0]} ${strings[1]} is not available")
        }
        else return data.searchMonthlyConsumption(year,month)!!
    }

}