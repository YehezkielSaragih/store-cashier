package util

class DiskonNominal(private val nominal: Int) : Diskon {
    override val nama = "Diskon Rp$nominal"
    override fun hitung(subtotal: Int): Int {
        return if (nominal > subtotal) subtotal else nominal
    }
}