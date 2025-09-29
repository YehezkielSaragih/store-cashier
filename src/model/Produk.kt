package model

data class Produk(
    val id: Long = nextId(),
    val nama: String,
    val harga: Int
) {
    companion object {
        private var counter: Long = 0
        private fun nextId(): Long {
            counter += 1
            return counter
        }
    }
}
