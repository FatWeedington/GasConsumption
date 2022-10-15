package model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month

internal class DataTest {

    val c1 = MonthlyConsumption(LocalDate.of(2021,12,31), LocalDate.of(2022,1,30),3312,3320,10.96)
    val c2 = MonthlyConsumption(LocalDate.of(2022,1,31), LocalDate.of(2022,2,27),3320,3461,10.92)
    val c3 = MonthlyConsumption(LocalDate.of(2022,2,28), LocalDate.of(2022,3,30),3461,3489,10.97)
    val c4 = MonthlyConsumption(LocalDate.of(2022,3,31), LocalDate.of(2022,4,29),3489,3564,10.86)
    val c5 = MonthlyConsumption(LocalDate.of(2022,4,30), LocalDate.of(2022,5,30),3564,3567,10.93)

    val p1 = YearlyConsumption(2022)
    val data = Data()

    init {
        p1.addConsumption(c1)
        p1.addConsumption(c2)
        p1.addConsumption(c3)
        p1.addConsumption(c4)
        p1.addConsumption(c5)

    }

    @Test
    fun searchMonthlyConsumption() {
        assertEquals(c1,data.searchMonthlyConsumption(2022,Month.JANUARY))
        assertEquals(c4,data.searchMonthlyConsumption(2022,Month.APRIL))
    }

    @Test
    fun searchYearlyConsumption() {
        assertEquals(p1,data.searchYearlyConsumption(2022))
    }
}