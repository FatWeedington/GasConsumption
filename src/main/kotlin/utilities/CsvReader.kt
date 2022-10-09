package utilities

import model.Data
import model.MonthlyConsumption
import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter

//function to generate a list Monthlyconsumption Objects based on data stored in file gasreading.csv
fun readCSV():List<MonthlyConsumption>{
    val consumptions:MutableList<MonthlyConsumption> = ArrayList()
    //read file line by line
    val lines :List<String> = File("data"+File.separator+"gasreading.csv").readLines()

    // iterate throug lines of csv
    for(l in lines.subList(1, lines.size)){
        // Split single line by ","
        val fields = l.split(",")

        //set the parameters for new Monthly consumption
        val beginDate = LocalDate.parse(fields[0], DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        val endDate = LocalDate.parse(fields[1], DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        val beginIndex = fields[2].toInt()
        val endIndex = fields[3].toInt()
        val kpsc = fields[4].toDouble()

        //Creates a new Monthly consumption Object
        val monthlyConsumption = MonthlyConsumption(beginDate,endDate,beginIndex,endIndex,kpsc)
        consumptions.add(monthlyConsumption)
       }
    return consumptions.toList()
}