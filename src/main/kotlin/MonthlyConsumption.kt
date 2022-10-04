import java.time.LocalDate
import java.time.Month
import kotlin.math.pow

class MonthlyConsumption(val beginDate: LocalDate,
                         val endDate:LocalDate,
                         val beginIndx:Int,
                         val endIndx:Int,
                         val kpcs:Double) {


    fun getConsumptionM3():Int{
        return endIndx - beginIndx
    }

    fun getConsumptionKWh():Double{
        return (getConsumptionM3()*kpcs).pow(1)
    }

    fun getYear():Int{
        return endDate.year
    }

    fun getMonth():Month{
        return endDate.month
    }
}