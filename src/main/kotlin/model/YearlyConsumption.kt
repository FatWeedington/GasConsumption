package model

import java.time.Month

class YearlyConsumption(val year:Int) {

    var monthlyConsumptions:MutableList<MonthlyConsumption> = mutableListOf()

    fun addConsumption(monthlyConsumption:MonthlyConsumption){
        monthlyConsumptions.add(monthlyConsumption)
    }

    fun getMonthsTotal():Int {
        return monthlyConsumptions.size
    }

    fun getTotalConsumption():Int{
        return monthlyConsumptions.map {c -> c.getConsumptionKWh()}.sum()
    }

    fun getMaxConsumption():Int{
        return monthlyConsumptions.map {c -> c.getConsumptionKWh()}.max()
    }

    fun getMinConsumption():Int{
        return monthlyConsumptions.map {c -> c.getConsumptionKWh()}.min()
    }

    fun getMaxMonth():Month{
        return monthlyConsumptions.filter { c -> c.getConsumptionKWh() == getMaxConsumption() }.map { c -> c.getMonth() }[0]
    }

    fun getMinMonth():Month{
        return monthlyConsumptions.filter { c -> c.getConsumptionKWh() == getMinConsumption() }.map { c -> c.getMonth() }[0]
    }

    fun getAverage():Double{
        return monthlyConsumptions.map {c -> c.getConsumptionKWh()}.average()
    }
}

