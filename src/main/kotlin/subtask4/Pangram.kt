package subtask4

class Pangram {

    fun getResult(inputString: String): String {
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'y')
        val regexForVowels = "[aeiouy]".toRegex()
        val regexForConsonants = "[qwrtpsdfghjklzxcvbnm]".toRegex()

        val isPangram = isStringPangram(inputString)

        val mutableListWords =
            inputString.replace('\n', ' ')
                .split(' ')
                .filter { it.isNotEmpty() }
                    as MutableList

        for (index in mutableListWords.indices) {
            mutableListWords[index] =
                if (isPangram) mutableListWords[index].count { char -> vowels.contains(char.toLowerCase()) }.toString() +
                        regexForVowels.replace(mutableListWords[index]) { vowel -> vowel.value.toUpperCase() }
                else mutableListWords[index].count { char -> !vowels.contains(char.toLowerCase()) and (char.toLowerCase() in 'a'..'z') }.toString() +
                        regexForConsonants.replace(mutableListWords[index]) { consonants -> consonants.value.toUpperCase() }
        }

        mutableListWords.sortWith(compareBy { it[0] })

        return mutableListWords.joinToString(" ")
    }

    private fun isStringPangram(string: String): Boolean {
        val variousLetterFromString = mutableSetOf<Char>()
        variousLetterFromString.addAll(string.toLowerCase().asIterable().filter { it in 'a'..'z' })
        return variousLetterFromString.size == 26
    }
}
