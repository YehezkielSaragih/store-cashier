package service

import model.*
import util.*

object Kasir {

    fun checkout(
        keranjang: Keranjang,
        kodeVoucher: String? = null,
        ppn: PajakPPN? = null
    ): Struk {

        val items = keranjang.getItems()
        val subtotal = keranjang.totalKotor()

        // Ambil diskon dari voucher
        val diskon: Diskon? = if (kodeVoucher != null) {
            Voucher.getDiskon(kodeVoucher)
        } else {
            null
        }

        val potongan = diskon?.hitung(subtotal) ?: 0
        val totalSetelahDiskon = (subtotal - potongan).coerceAtLeast(0)

        val ppnNominal = ppn?.hitung(totalSetelahDiskon) ?: 0
        val totalAkhir = (totalSetelahDiskon + ppnNominal).coerceAtLeast(0)

        return Struk(
            items = items,
            subtotal = subtotal,
            potongan = potongan,
            ppn = ppnNominal,
            total = totalAkhir,
            kodeVoucher = kodeVoucher ?: "N/A",
            namaDiskon = diskon?.nama ?: "Tanpa Diskon"
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
                    item.hargaSatuan,
                    item.subtotal
                )
            )
        }
        println("----------------------------")
        println(String.format("%-20s %s", "Voucher  :", struk.kodeVoucher))
        println(String.format("%-20s %s", "Diskon   :", struk.namaDiskon))
        println(String.format("%-20s %10d", "Subtotal :", struk.subtotal))
        println(String.format("%-20s %10d", "Diskon   :", struk.potongan))
        println(String.format("%-20s %10d", "PPN 11%  :", struk.ppn))
        println(String.format("%-20s %10d", "Total    :", struk.total))
        println("============================")
    }
}
