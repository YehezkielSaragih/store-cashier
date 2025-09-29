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

    fun totalBersih(kodeVoucher: String? = null, ppn: PajakPPN? = null): Int {
        val subtotal = totalKotor()

        // Ambil diskon dari voucher
        val diskon: Diskon? = if (kodeVoucher != null) {
            Voucher.getDiskon(kodeVoucher)
        } else {
            null
        }
        val potongan = diskon?.hitung(subtotal) ?: 0
        val totalSetelahDiskon = (subtotal - potongan).coerceAtLeast(0)

        val ppnNominal = ppn?.hitung(totalSetelahDiskon) ?: 0
        return (totalSetelahDiskon + ppnNominal).coerceAtLeast(0)
    }

}