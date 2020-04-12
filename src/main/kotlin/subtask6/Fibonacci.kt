package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        var f1 = 0
        var f2 = 1

        while (f1 * f2 <= n) {
            val temp = f2
            f2 += f1
            f1 = temp
        }

        return if (f1 * f2 == n) intArrayOf(f1, f2, 1) else intArrayOf(f1, f2, 0)
    }
}
