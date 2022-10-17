package model

import java.time.LocalDate
import java.time.Month
import kotlin.math.roundToInt

data class MonthlyConsumption(private val beginDate: LocalDate,
                              private val endDate:LocalDate,
                              private val beginIndex:Int,
                              private val endIndex:Int,
                              private val kpcs:Double) {

    //calculates and returns Consumption in m3 of month given the start and end indices
    fun getConsumptionM3() = endIndex - beginIndex


    //calculates and returns gas consumption in KwH
    fun getConsumptionKWh() = (getConsumptionM3()*kpcs)


    //returns year of the Month
    fun getYear() =  endDate.year


    //returns Month as a Month object
    fun getMonth(): Month = endDate.month


    //Prints parameters to cli
    override fun toString():String{
        return String.format("%-9s %-6s %-17s %-18s",getMonth().name.lowercase()
            .replaceFirstChar { it.titlecase() }
            ,getYear(),getConsumptionM3(),getConsumptionKWh().roundToInt())
    }
}