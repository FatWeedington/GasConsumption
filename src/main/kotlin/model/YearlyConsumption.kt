package model

import utilities.round
import java.time.Month
import kotlin.math.roundToInt

//represents a summary of all Monthly consumption objects in one year and calculates required parameters
data class YearlyConsumption(val year:Int) {

    private val monthlyConsumptions= mutableListOf<MonthlyConsumption>()

    //add new monthly consumption to year
    fun addConsumption(monthlyConsumption:MonthlyConsumption){
        if(!monthlyConsumptions.stream().map { c -> c.getMonth()}.anyMatch {c -> c.equals(monthlyConsumption.getMonth())}){
        monthlyConsumptions.add(monthlyConsumption)}
        }


    //returns total of MonthlyConsumption objects stored
    fun getMonthsTotal():Int {
        return monthlyConsumptions.size
    }

    //returns total gas consumption of the year
    fun getTotalConsumption():Double{
        return monthlyConsumptions.map {c -> c.getConsumptionKWh()}.sum()
    }

    //returns maximal gas consumption in one month within the year
    fun getMaxConsumption():Double{
        return monthlyConsumptions.map {c -> c.getConsumptionKWh()}.max()
    }

    //returns minimal gas consumption in one month within the year
    fun getMinConsumption():Double{
        return monthlyConsumptions.map {c -> c.getConsumptionKWh()}.min()
    }

    //returns the Month with maximal gas consumption within the year
    fun getMaxMonth():Month{
        return monthlyConsumptions.filter { c -> c.getConsumptionKWh() == getMaxConsumption() }.map { c -> c.getMonth() }[0]
    }

    //returns the Month with minimal gas consumption within the year
    fun getMinMonth():Month{
        return monthlyConsumptions.filter { c -> c.getConsumptionKWh() == getMinConsumption() }.map { c -> c.getMonth() }[0]
    }

    //returns average fuel consumption per month
    fun getAverage():Double{
        return round(monthlyConsumptions.map {c -> c.getConsumptionKWh()}.average(),2)
    }

    //Prints parameters to cli
    override fun toString():String{
        return String.format("%-5s %-13s %-17s %-9s %-10s %-8s %-10s %-10s",year,getMonthsTotal(),getTotalConsumption().roundToInt().toString()+"kWh",getMaxConsumption().roundToInt().toString()+"kWh",
            getMaxMonth().name.lowercase().replaceFirstChar { it.titlecase()},getMinConsumption().roundToInt().toString()+"kWh",
            getMinMonth().name.lowercase().replaceFirstChar { it.titlecase()},getAverage().toString()+"kWh")
    }

}

