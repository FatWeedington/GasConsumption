package model

import java.time.LocalDate
import java.time.Month
import java.util.*
import kotlin.math.pow
import kotlin.math.roundToInt

class MonthlyConsumption(private val beginDate: LocalDate,
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MonthlyConsumption

        if (beginDate != other.beginDate) return false
        if (endDate != other.endDate) return false
        if (beginIndx != other.beginIndx) return false
        if (endIndx != other.endIndx) return false
        if (kpcs != other.kpcs) return false

        return true
    }

    override fun hashCode(): Int {
        var result = beginDate.hashCode()
        result = 31 * result + endDate.hashCode()
        result = 31 * result + beginIndx
        result = 31 * result + endIndx
        result = 31 * result + kpcs.hashCode()
        return result
    }
}