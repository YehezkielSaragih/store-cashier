package model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

data class Struk(
    val kode: String = generateKode(),
    val tanggal: String,
    val items: List<ItemKeranjang>,
    val subtotal: Int,
    val potongan: Int,
    val total: Int
) {
    companion object {
        fun generateKode(): String {
            val ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
            val rand = Random.nextInt(100, 999)
            return "STRK-$ts-$rand"
        }

        fun nowFormatted(): String {
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        }
    }
}