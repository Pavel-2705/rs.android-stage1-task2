package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        val minute = minute.toInt()
        val hour = hour.toInt()

        val numeralWords = arrayOf(
            "", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "then",
            "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen", "twenty", "twenty one", "twenty two",
            "twenty three", "twenty four", "twenty five",
            "twenty six", "twenty seven", "twenty eight", "twenty nine"
        )

        if (minute > 60 || hour > 12) return numeralWords[0]

        return when (minute) {
            0 -> "${numeralWords[hour]} o' clock"
            1 -> "${numeralWords[1]} minute past ${numeralWords[hour]}"
            15 -> "quarter past ${numeralWords[hour]}"
            30 -> "half past ${numeralWords[hour]}"
            45 -> "quarter to ${numeralWords[hour + 1]}"
            in 1 until 30 -> "${numeralWords[minute]} minutes past ${numeralWords[hour]}"
            in 31..60 -> "${numeralWords[60 - minute]} minutes to ${numeralWords[hour + 1]}"

            else -> numeralWords[0]
        }
    }
}
