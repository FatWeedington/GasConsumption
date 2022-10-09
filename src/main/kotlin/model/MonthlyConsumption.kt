package model

import java.time.LocalDate
import java.time.Month
import kotlin.math.pow
import kotlin.math.roundToInt

class MonthlyConsumption(val beginDate: LocalDate,
                         val endDate:LocalDate,
                         val beginIndx:Int,
                         val endIndx:Int,
                         val kpcs:Double) {


    fun getConsumptionM3():Int{
        return endIndx - beginIndx
    }

    fun getConsumptionKWh():Int{
        return (getConsumptionM3()*kpcs).roundToInt()
    }

    fun getYear():Int{
        return endDate.year
    }

    fun getMonth():Month{
        return endDate.month
    }
}