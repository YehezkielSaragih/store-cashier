package model

data class Struk(
    val kode: String,
    val tanggal: String,
    val items: List<ItemKeranjang>,
    val subtotal: Int,
    val potongan: Int,
    val total: Int
) {

}