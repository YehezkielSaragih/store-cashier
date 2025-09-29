package model

data class ItemKeranjang(
    val produk: Produk,
    var jumlah: Int,
    val hargaSatuan: Int = produk.harga
) {
    val subtotal: Int
        get() = hargaSatuan * jumlah
}