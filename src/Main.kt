import model.*
import service.*
import util.*

fun main() {
    val p1 = Produk(nama = "Sabun", harga = 50000)
    val p2 = Produk(nama = "Shampoo", harga = 10000)
    val p3 = Produk(nama = "Odol", harga = 120000)

    val keranjang = Keranjang()
    keranjang.tambahProduk(p1, 2)
    keranjang.tambahProduk(p2, 1)
    keranjang.tambahProduk(p3, 3)

    // Pakai voucher diskon
    val diskonVoucher = Voucher.getDiskon("HEMAT10") // 10% potongan

    // Pakai PPN 11%
    val ppn = PajakPPN(11)

    val strukVoucher = Kasir.checkout(keranjang, diskonVoucher, ppn)
    println("\n=== Struk dengan Voucher HEMAT10 + PPN 11% ===")
    Kasir.cetakStruk(strukVoucher)

    // Diskon bertingkat
    val diskonBertingkat = DiskonBertingkat()
    val strukBertingkat = Kasir.checkout(keranjang, diskonBertingkat, ppn)
    println("\n=== Struk dengan Diskon Bertingkat + PPN 11% ===")
    Kasir.cetakStruk(strukBertingkat)
}
