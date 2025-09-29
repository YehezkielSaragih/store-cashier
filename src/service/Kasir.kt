package service

import model.*
import util.*

object Kasir {
    fun checkout(keranjang: Keranjang, diskon: Diskon, ppn: PajakPPN? = null): Struk {
        val items = keranjang.getItems()
        val subtotal = keranjang.totalKotor()

        // Hitung diskon
        val potongan = diskon.hitung(subtotal)
        val totalSetelahDiskon = (subtotal - potongan).coerceAtLeast(0)

        // Hitung PPN (jika ada)
        val ppnNominal = ppn?.hitung(totalSetelahDiskon) ?: 0

        // Total akhir setelah diskon + PPN
        val totalAkhir = (totalSetelahDiskon + ppnNominal).coerceAtLeast(0)

        return Struk(
            items = items,
            subtotal = subtotal,
            potongan = potongan,
            ppn = ppnNominal,       // ✅ simpan ke Struk
            total = totalAkhir
        )
    }

    fun cetakStruk(struk: Struk) {
        println("========== STRUK ==========")
        println("Kode     : ${struk.kode}")
        println("Tanggal  : ${struk.tanggal}")
        println("----------------------------")
        println(String.format("%-12s %3s %7s %8s", "Nama", "Qty", "Harga", "Total"))
        struk.items.forEach { item ->
            println(
                String.format(
                    "%-12s %3d %7d %8d",
                    item.produk.nama,
                    item.jumlah,
                    item.produk.harga,
                    item.subtotal
                )
            )
        }
        println("----------------------------")
        println(String.format("%-20s %10d", "Subtotal :", struk.subtotal))
        println(String.format("%-20s %10d", "Diskon   :", struk.potongan))
        println(String.format("%-20s %10d", "PPN 11%  :", struk.ppn)) // ✅ tampilkan PPN
        println(String.format("%-20s %10d", "Total    :", struk.total))
        println("============================")
    }
}
