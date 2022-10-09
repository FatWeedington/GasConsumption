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


    fun getConsumptionM3():Int{
        return endIndx - beginIndx
    }

    fun getConsumptionKWh():Double{
        return (getConsumptionM3()*kpcs)
    }

    fun getYear():Int{
        return endDate.year
    }

    fun getMonth():Month{
        return endDate.month
    }

    override fun toString():String{
        return String.format("%-9s %-6s %-17s %-18s",getMonth().name.lowercase(Locale.getDefault()).replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }, getYear(),getConsumptionM3(),getConsumptionKWh().roundToInt())
    }
}