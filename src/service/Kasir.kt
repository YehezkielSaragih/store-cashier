package service

import model.Struk
import util.Diskon

object Kasir {
    fun checkout(keranjang: Keranjang, diskon: Diskon): Struk {
        val items = keranjang.getItems()
        val subtotal = keranjang.totalKotor()
        val potongan = diskon.hitung(subtotal)
        val total = subtotal - potongan

        return Struk(
            kode = Struk.generateKode(),
            tanggal = Struk.nowFormatted(),
            items = items,
            subtotal = subtotal,
            potongan = potongan,
            total = if (total < 0) 0 else total
        )
    }

    fun cetakStruk(struk: Struk) {
        println("========== STRUK ==========")
        println("Kode     : ${struk.kode}")
        println("Tanggal  : ${struk.tanggal}")
        println("----------------------------")
        struk.items.forEach { item ->
            val hargaTotal = item.produk.harga * item.jumlah
            println("${item.produk.nama} x${item.jumlah} = Rp$hargaTotal")
        }
        println("----------------------------")
        println("Subtotal : Rp${struk.subtotal}")
        println("Diskon   : Rp${struk.potongan}")
        println("Total    : Rp${struk.total}")
        println("============================")
    }
}