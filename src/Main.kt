import model.*
import service.*
import util.*

fun main() {

    val p1 = Produk(nama = "Sabun", harga = 5000)
    val p2 = Produk(nama = "Shampoo", harga = 15000)
    val p3 = Produk(nama = "Odol", harga = 12000)

    val keranjang = Keranjang()
    keranjang.tambahProduk(p1, 2)
    keranjang.tambahProduk(p2, 1)
    keranjang.tambahProduk(p3, 3)

    val diskon = DiskonPersen(10)

    val struk = Kasir.checkout(keranjang, diskon)
    Kasir.cetakStruk(struk)
}