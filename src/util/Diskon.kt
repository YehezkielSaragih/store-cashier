package util

interface Diskon {
    val nama: String
    fun hitung(subtotal: Int): Int
}