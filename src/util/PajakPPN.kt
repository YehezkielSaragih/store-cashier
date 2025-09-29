package util

class PajakPPN(private val persen: Int = 11) {
    fun hitung(totalSetelahDiskon: Int): Int {
        return totalSetelahDiskon * persen / 100
    }
}
