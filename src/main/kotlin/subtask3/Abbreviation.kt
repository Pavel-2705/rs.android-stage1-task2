package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val tempA = StringBuilder(a.toUpperCase())
        var index = 0

        while (b.length <= tempA.length && b.length != index) {
            if (tempA[index] != b[index]) {
                tempA.deleteCharAt(index)
                index--
            }
            index++
        }

        return if (index == b.length) "YES" else "NO"
    }
}
