package util

class DiskonPersen(private val persen: Int) : Diskon {
    override fun hitung(subtotal: Int): Int {
        val potongan = subtotal * persen / 100
        return if (potongan > subtotal) subtotal else potongan
    }
}