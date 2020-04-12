package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        val locale = Locale("ru")
        val dateFormat = "dd.MM.yyyy"

        return when (blockB) {
            Int::class -> blockA.filterIsInstance<Int>().sum()
            String::class -> blockA.filterIsInstance<String>().joinToString("")
            else -> blockA.filterIsInstance<LocalDate>().max()!!.format(
                DateTimeFormatter.ofPattern(dateFormat, locale)
            )
        }


    }
}
