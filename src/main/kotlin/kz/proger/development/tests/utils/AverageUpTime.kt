package kz.proger.development.tests.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun main() {
    val dates = listOf(
        "2019-12-25 11:55:08",
        "2019-12-26 09:23:26",
        "2019-12-27 11:40:33",
        "2019-12-27 16:38:01",
        "2019-12-28 15:37:54",
        "2019-12-29 14:06:47",
        "2019-12-30 08:58:25",
        "2019-12-30 11:13:56",
        "2019-12-30 17:19:53",
        "2019-12-30 19:59:10",
        "2019-12-31 13:46:32",
        "2019-12-31 18:02:31",
        "2020-01-02 14:38:00",
        "2020-01-02 14:38:50",
        "2020-01-03 16:07:08",
        "2020-01-05 12:40:24",
        "2020-01-06 15:11:34",
        "2020-01-07 13:45:18",
        "2020-01-07 17:39:42",
        "2020-01-08 14:59:15"
    )

    val localDates = dates.map { LocalDateTime.parse(it, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) }
    val hours = arrayListOf<Long>()
    for (i in 1 until dates.size) {
        hours.add(localDates[i - 1].until(localDates[i], ChronoUnit.HOURS))
    }
    println(hours.average())
}