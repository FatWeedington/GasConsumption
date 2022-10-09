package model

import utilities.readCSV
import java.time.Month

class Data {

    private var monthlyConsumptions:MutableList<MonthlyConsumption> = ArrayList()
    private var yearlyConsumptions:MutableMap<Int,YearlyConsumption> = HashMap()
    init {
        //read csv file
        readCSV(this)
        //create yearlyConsumptions in Map
        for(monthlyconsumption in monthlyConsumptions){
            if(yearlyConsumptions.containsKey(monthlyconsumption.getYear())){
                yearlyConsumptions[monthlyconsumption.getYear()]?.addConsumption(monthlyconsumption)
            }
            else{
                val yearlyConsumption = YearlyConsumption((monthlyconsumption.getYear()) )
                yearlyConsumption.addConsumption(monthlyconsumption)
                yearlyConsumptions[monthlyconsumption.getYear()] = yearlyConsumption
            }
        }
    }

    fun addMonthlyConsumption(monthlyConsumption: MonthlyConsumption){
        monthlyConsumptions.add(monthlyConsumption)
    }

    fun getMonthlyConsumptions():List<MonthlyConsumption>{
        return monthlyConsumptions.toList()
    }

    fun getYearlyConsumptions():List<YearlyConsumption>{
        return yearlyConsumptions.values.toList()
    }

    fun searchMonthlyConsumption(year:Int, month: Month):MonthlyConsumption{
        return monthlyConsumptions.filter { it.getYear() == year}.filter { it.getMonth() == month }[0]
    }

    fun searchYearlyConsumption(year: Int): YearlyConsumption {
        if (yearlyConsumptions.containsKey(year)){
        return yearlyConsumptions[year]!!
        }
        else{
            throw Exception();
        }
    }
}