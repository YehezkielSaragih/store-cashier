package service

import model.*
import util.*

class Keranjang {

    private val items = mutableListOf<ItemKeranjang>()

    fun tambahProduk(produk: Produk, jumlah: Int = 1) {
        // Check if the product already exists in the cart by matching its ID
        val existing = items.find { it.produk.id == produk.id }
        if (existing != null) {
            // If the product is already in the cart, update its quantity
            existing.jumlah += jumlah
        } else {
            // If the product is not in the cart, add it as a new item
            items.add(ItemKeranjang(produk, jumlah))
        }
    }

    fun hapusProduk(produk: Produk) {
        items.removeIf { it.produk.id == produk.id }
    }

    fun getItems(): List<ItemKeranjang> = items.toList()

    fun totalKotor(): Int = items.sumOf { it.produk.harga * it.jumlah }

    fun totalBersih(diskon: Diskon): Int {
        val subtotal = totalKotor()
        val potongan = diskon.hitung(subtotal)
        val total = subtotal - potongan
        return if (total < 0) 0 else total
    }
}