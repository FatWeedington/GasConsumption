package model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import utilities.round
import java.awt.JobAttributes
import java.time.LocalDate
import java.time.Month

internal class YearlyConsumptionTest {


    val c1 = MonthlyConsumption(LocalDate.of(2021,12,31), LocalDate.of(2022,1,31),10,12,10.81)
    val c2 = MonthlyConsumption(LocalDate.of(2022,2,28), LocalDate.of(2022,3,30),10,13,10.91)
    val c3 = MonthlyConsumption(LocalDate.of(2022,1,31), LocalDate.of(2022,2,27),19,20,10.0)

    val p1 = YearlyConsumption(2022)
    val p2 = YearlyConsumption(2022)
    val p3 = YearlyConsumption(2022)

    init {
        p1.addConsumption(c1)
        p2.addConsumption(c2)
        p3.addConsumption(c3)
    }

    @Test
    fun addConsumption() {
        assertEquals(1,p1.getMonthsTotal())
        p1.addConsumption(c1)
        assertEquals(1,p1.getMonthsTotal())
        p1.addConsumption(c2)
        assertEquals(2,p1.getMonthsTotal())
    }

    @Test
    fun getMonthsTotal() {
        assertEquals(1,p1.getMonthsTotal())
        p1.addConsumption(c2)
        assertEquals(2,p1.getMonthsTotal())
    }

    @Test
    fun getTotalConsumption() {
        assertEquals(2*10.81,p1.getTotalConsumption())
        p1.addConsumption(c2)
        assertEquals((2*10.81)+(3*10.91),p1.getTotalConsumption())
    }

    @Test
    fun getMaxConsumption() {
        assertEquals(2*10.81,p1.getMaxConsumption())
        p1.addConsumption(c2)
        assertEquals(3*10.91,p1.getMaxConsumption())
    }

    @Test
    fun getMinConsumption() {
        assertEquals(2*10.81,p1.getMinConsumption())
        p1.addConsumption(c3)
        assertEquals(1*10.0,p1.getMinConsumption())
    }

    @Test
    fun getMaxMonth() {
        assertEquals(Month.JANUARY,p1.getMaxMonth())
        p1.addConsumption(c2)
        assertEquals(Month.MARCH,p1.getMaxMonth())
    }

    @Test
    fun getMinMonth() {
        assertEquals(Month.JANUARY,p1.getMinMonth())
        p1.addConsumption(c3)
        assertEquals(Month.FEBRUARY,p1.getMinMonth())
    }

    @Test
    fun getAverage() {
        assertEquals(2*10.81,p1.getAverage())
        p1.addConsumption(c2)
        assertEquals(round(listOf(2*10.81,3*10.91).average(),2),p1.getAverage())
    }

    @Test
    fun testToString() {
        String.format("%-5s %-13s %-17s %-9s %-10s %-8s %-10s %-10s","2022","1","22kWh","22kWh","January","22kWh","January","22kWh")
    }

    @Test
    fun getYear() {
        assertEquals(2022,p1.year)
    }
}