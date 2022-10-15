package model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month

internal class MonthlyConsumptionTest {

    val c1 = MonthlyConsumption(LocalDate.of(2021,12,31),LocalDate.of(2022,1,31),10,12,10.81)
    val c2 = MonthlyConsumption(LocalDate.of(2021,12,31),LocalDate.of(2022,1,31),10,12,10.81)
    val c3 = MonthlyConsumption(LocalDate.of(2022,1,31),LocalDate.of(2022,2,27),10,12,10.81)
    val c4 = MonthlyConsumption(LocalDate.of(2021,12,31),LocalDate.of(2022,1,31),10,13,10.81)
    val c5 = MonthlyConsumption(LocalDate.of(2021,12,31),LocalDate.of(2022,1,31),9,12,10.81)
    val c6 = MonthlyConsumption(LocalDate.of(2022,12,31),LocalDate.of(2023,1,31),10,12,9.11)

    @Test
    fun constructor(){
        assertEquals(c1,c2)
        assertNotEquals(c1,c3)
        assertNotEquals(c1,c4)
        assertNotEquals(c1,c5)
        assertNotEquals(c1,c6)
    }

    @Test
    fun getConsumptionM3() {
        assertEquals(2,c1.getConsumptionM3())
        assertEquals(3,c4.getConsumptionM3())
        assertEquals(3,c5.getConsumptionM3())
    }

    @Test
    fun getConsumptionKWh() {
        assertEquals((12-10)*10.81,c1.getConsumptionKWh())
        assertEquals((13-10)*10.81,c4.getConsumptionKWh())
        assertEquals((12-10)*9.11,c6.getConsumptionKWh())
    }

    @Test
    fun getYear() {
        assertEquals(2022,c1.getYear())
        assertEquals(2023,c6.getYear())
    }

    @Test
    fun getMonth() {
        assertEquals(Month.JANUARY,c1.getMonth())
        assertEquals(Month.FEBRUARY,c3.getMonth())
    }

    @Test
    fun testToString() {
        assertEquals(String.format("%-9s %-6s %-17s %-18s","January","2022","2","22"),c1.toString())
        assertEquals(String.format("%-9s %-6s %-17s %-18s","January","2023","2","18"),c6.toString())
    }
}