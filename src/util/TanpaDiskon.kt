package util

class TanpaDiskon : Diskon {
    override val nama = "Tanpa Diskon"
    override fun hitung(subtotal: Int): Int = 0
}