package model

import utilities.readCSV

class Data {
    private var monthlyConsumptions:MutableList<MonthlyConsumption> = mutableListOf()
    private var yearlyConsumptions:MutableMap<Int,YearlyConsumption> = mutableMapOf()

    fun addMonthlyConsumption(monthlyConsumption: MonthlyConsumption){
        monthlyConsumptions.add(monthlyConsumption)
    }


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
                yearlyConsumptions[monthlyconsumption.getYear()]?.addConsumption(monthlyconsumption)
            }
        }
    }
}