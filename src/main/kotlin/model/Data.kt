package model

import utilities.readCSV
import java.time.Month


//represtents storage of Monhly/Yearly gas consumptions
class Data {

    private var monthlyConsumptions= ArrayList<MonthlyConsumption>()
    private var yearlyConsumptions= HashMap<Int,YearlyConsumption>()
    init {
        //read csv file and adds MotnhlyCosumptions to internal list
        monthlyConsumptions.addAll(readCSV())
        //create yearlyConsumptions or all years in Map
        for(monthlyConsumption in monthlyConsumptions){
            if(yearlyConsumptions.containsKey(monthlyConsumption.getYear())){
                yearlyConsumptions[monthlyConsumption.getYear()]?.addConsumption(monthlyConsumption)
            }
            else{
                val yearlyConsumption = YearlyConsumption((monthlyConsumption.getYear()) )
                yearlyConsumption.addConsumption(monthlyConsumption)
                yearlyConsumptions[monthlyConsumption.getYear()] = yearlyConsumption
            }
        }
    }

    // returns immutable list of all monthly consumption objects stored
    fun getMonthlyConsumptions():List<MonthlyConsumption>{
        return monthlyConsumptions.toList()
    }

    // returns immutable list of all yearly consumption objects stored
    fun getYearlyConsumptions():List<YearlyConsumption>{
        return yearlyConsumptions.values.toList()
    }

    //searches Monthly consumption list for Object with specified year and month
    fun searchMonthlyConsumption(year:Int, month: Month):MonthlyConsumption{
        return monthlyConsumptions.filter { it.getYear() == year}.filter { it.getMonth() == month }[0]
    }

    //searches yearly consumption list for Object with specified year
    fun searchYearlyConsumption(year: Int): YearlyConsumption? {
        return yearlyConsumptions[year]
    }
}