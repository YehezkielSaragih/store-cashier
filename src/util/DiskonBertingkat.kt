package util

class DiskonBertingkat : Diskon {
    override fun hitung(subtotal: Int): Int {
        val persen = when {
            subtotal >= 500_000 -> 10
            subtotal >= 300_000 -> 5
            else -> 0
        }
        return subtotal * persen / 100
    }
}