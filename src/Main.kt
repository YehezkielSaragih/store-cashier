import model.*
import service.*
import util.*

fun main() {

    // Setup product
    val p1 = Produk(nama = "Sabun", harga = 50000)
    val p2 = Produk(nama = "Shampoo", harga = 10000)
    val p3 = Produk(nama = "Odol", harga = 120000)

    // Setup cart
    val keranjang = Keranjang()
    keranjang.tambahProduk(p1, 2)
    keranjang.tambahProduk(p2, 1)
    keranjang.tambahProduk(p3, 3)

    // Delete product
    println("Total kotor sebelum hapus: ${keranjang.totalKotor()}")
    keranjang.hapusProduk(p2)
    println("Total kotor setelah hapus Shampoo: ${keranjang.totalKotor()}")

    // Apply PPN 11%
    val ppn = PajakPPN(11)

    // Struk with voucher "HEMAT10"
    val strukHemat10 = Kasir.checkout(keranjang, kodeVoucher = "HEMAT10", ppn = ppn)
    println("\nStruk with Voucher HEMAT10 + PPN 11% ")
    Kasir.cetakStruk(strukHemat10)

    // Struk with voucher "POTONG20"
    val strukPotong20 = Kasir.checkout(keranjang, kodeVoucher = "POTONG20K", ppn = ppn)
    println("\nStruk with Voucher POTONG20 + PPN 11%")
    Kasir.cetakStruk(strukPotong20)

    // Struk with voucher "BERTINGKAT"
    val strukBertingkat = Kasir.checkout(keranjang, kodeVoucher = "BERTINGKAT", ppn = ppn)
    println("\nStruk with Voucher BERTINGKAT + PPN 11%")
    Kasir.cetakStruk(strukBertingkat)

    // Struk withOUT voucher
    val strukTanpaVoucher = Kasir.checkout(keranjang, kodeVoucher = null, ppn = ppn)
    println("\nStruk without Voucher + PPN 11%")
    Kasir.cetakStruk(strukTanpaVoucher)
}
