package model

data class ItemKeranjang(
    val produk: Produk,
    var jumlah: Int
) {
    val subtotal: Int
        get() = produk.harga * jumlah
}