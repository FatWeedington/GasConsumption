package model

import java.time.LocalDate
import java.time.Month
import java.util.*
import kotlin.math.pow
import kotlin.math.roundToInt

data class MonthlyConsumption(private val beginDate: LocalDate,
                         private val endDate:LocalDate,
                         private val beginIndx:Int,
                         private val endIndx:Int,
                         private val kpcs:Double) {

    //calculates and returns Consumption in m3 of month given the start and end indices
    fun getConsumptionM3():Int{
        return endIndx - beginIndx
    }

    //calculates and returns gas consumption in KwH
    fun getConsumptionKWh():Double{
        return (getConsumptionM3()*kpcs)
    }

    //returns year of the Month
    fun getYear():Int{
        return endDate.year
    }

    //returns Month as a Month object
    fun getMonth():Month{
        return endDate.month
    }

    //Prints parameters to cli
    override fun toString():String{
        return String.format("%-9s %-6s %-17s %-18s",getMonth().name.lowercase(Locale.getDefault())
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            ,getYear(),getConsumptionM3(),getConsumptionKWh().roundToInt())
    }
}