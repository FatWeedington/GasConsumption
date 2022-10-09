package apps

import model.Data
import utilities.ConsoleInput
import utilities.menu.Menu
import utilities.menu.MenuItem
import utilities.round
import utilities.validators.MonthlyConsumptionValidator
import utilities.validators.UnitValidator
import utilities.validators.YearlyConsumptionValidator
import java.util.*


private val data = Data()

//initializes Menu and Menu items for cli application
fun initMenu(): Menu {
        val mainMenu = Menu()

        mainMenu.add(MenuItem("cm", "Calculate consumptions for every Month", calcMonths))
        mainMenu.add(MenuItem("cy", "Calculate consumptions for every Year", calcYears))
        mainMenu.add(MenuItem("m", "Get information about a specific month", queryMonth))
        mainMenu.add(MenuItem("y", "Get information about a specific year", queryYear))
        mainMenu.add(MenuItem("Q", "Quit Application", null))

        return mainMenu;
    }


    private val queryYear = Runnable {
        val yearlyConsumption = ConsoleInput("Enter year",YearlyConsumptionValidator(), data).enterValue()
        println(String.format("%-5s %-13s %-17s %-9s %-10s %-8s %-10s %-10s","Year","Total Months", "TotalConsumption","Max","Max_Month","Min","Min_Month","Average"))
        println(yearlyConsumption.toString()+"\n")
    }

    private val queryMonth = Runnable {
        val monthlyConsumption = ConsoleInput("Enter Month and Year",MonthlyConsumptionValidator(), data).enterValue()
        val unit = ConsoleInput("Do you want Consumption by m3 or by kWh? m3:m3 and kWh:kWh",UnitValidator(), data).enterValue()
        print(String.format("%-15s",
            monthlyConsumption.getMonth().name.lowercase()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }+" "+monthlyConsumption.getYear()))
        if (unit){
            print(monthlyConsumption.getConsumptionM3().toString()+"m3"+"\n"+"\n")
        }
        else {
            print(round(monthlyConsumption.getConsumptionKWh(),2).toString()+"kWh"+"\n"+"\n")
        }
    }

    private val calcMonths = Runnable {
        println(String.format("%-16s %-17s %-18s","Month and Year", "Consumption m3","Consumption kWh"))
        data.getMonthlyConsumptions().forEach { println(it) }
        println()
    }

    private val calcYears = Runnable {
        println(String.format("%-5s %-13s %-17s %-9s %-10s %-8s %-10s %-10s","Year","Total Months", "TotalConsumption","Max","Max_Month","Min","Min_Month","Average"))
        data.getYearlyConsumptions().forEach { println(it)}
        println()
    }

//starts program
fun main() {
        initMenu().run()
    }






