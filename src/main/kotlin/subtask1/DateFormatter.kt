package subtask1

import java.lang.IllegalArgumentException
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class DateFormatter {

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {
        val locale = Locale("ru")
        val dateFormat = "d MMMM, EEEE"

        return try {
            val calendar = GregorianCalendar()
            calendar.isLenient = false
            calendar.set(Calendar.DAY_OF_MONTH, day.toInt())
            calendar.set(Calendar.MONTH, month.toInt() - 1)
            calendar.set(Calendar.YEAR, year.toInt())

            val specialDateFormat = SimpleDateFormat(dateFormat, locale)
            specialDateFormat.format(calendar.time)

        } catch (e: IllegalArgumentException) {
            "Такого дня не существует"
        }
    }
}
