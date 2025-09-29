package service

import model.*
import util.*

class Keranjang {

    private val items = mutableListOf<ItemKeranjang>()

    fun tambahProduk(produk: Produk, qty: Int = 1) {
        val existing = items.find { it.produk.id == produk.id }
        if (existing != null) {
            val idx = items.indexOf(existing)
            items[idx] = existing.copy(jumlah = existing.jumlah + qty)
        } else {
            items.add(ItemKeranjang(produk, qty))
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