package util

class DiskonNominal(private val nominal: Int) : Diskon {
    override fun hitung(subtotal: Int): Int {
        return if (nominal > subtotal) subtotal else nominal
    }
}