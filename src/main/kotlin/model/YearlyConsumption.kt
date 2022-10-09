package model

import utilities.round
import java.time.Month
import java.util.*
import kotlin.math.roundToInt

class YearlyConsumption(val year:Int) {

    private val monthlyConsumptions:MutableList<MonthlyConsumption> = mutableListOf()

    fun addConsumption(monthlyConsumption:MonthlyConsumption){
        monthlyConsumptions.add(monthlyConsumption)
    }

    fun getMonthsTotal():Int {
        return monthlyConsumptions.size
    }

    fun getTotalConsumption():Double{
        return monthlyConsumptions.map {c -> c.getConsumptionKWh()}.sum()
    }

    fun getMaxConsumption():Double{
        return monthlyConsumptions.map {c -> c.getConsumptionKWh()}.max()
    }

    fun getMinConsumption():Double{
        return monthlyConsumptions.map {c -> c.getConsumptionKWh()}.min()
    }

    fun getMaxMonth():Month{
        return monthlyConsumptions.filter { c -> c.getConsumptionKWh() == getMaxConsumption() }.map { c -> c.getMonth() }[0]
    }

    fun getMinMonth():Month{
        return monthlyConsumptions.filter { c -> c.getConsumptionKWh() == getMinConsumption() }.map { c -> c.getMonth() }[0]
    }

    fun getAverage():Double{
        return round(monthlyConsumptions.map {c -> c.getConsumptionKWh()}.average(),2)
    }

    override fun toString():String{
        return String.format("%-5s %-13s %-17s %-9s %-10s %-8s %-10s %-10s",year,getMonthsTotal(),getTotalConsumption().roundToInt().toString()+"kWh",getMaxConsumption().roundToInt().toString()+"kWh",getMaxMonth().name.lowercase(
            Locale.getDefault()).replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },getMinConsumption().roundToInt().toString()+"kWh",getMinMonth().name.lowercase(
            Locale.getDefault()).replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },getAverage())
    }
}

