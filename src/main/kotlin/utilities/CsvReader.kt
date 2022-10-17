package utilities

import model.MonthlyConsumption
import java.io.File
import java.io.FileReader
import java.time.LocalDate
import java.time.format.DateTimeFormatter

//function to generate a list Monthlyconsumption Objects based on data stored in file gasreading.csv
fun readCSV():List<MonthlyConsumption>{
    val consumptions = ArrayList<MonthlyConsumption>()
    //read file line by line
    val lines = FileReader("data"+File.separator+"gasreading.csv").useLines { it.toList() }

    // iterate through lines of csv
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