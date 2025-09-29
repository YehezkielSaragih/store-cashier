package model

data class Produk(
    val id: Long,
    val nama: String,
    val harga: Int
) {
    companion object {
        private var counter: Long = 0

        fun create(nama: String, harga: Int): Produk {
            counter += 1
            return Produk(counter, nama, harga)
        }
    }
}