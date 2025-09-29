package service

import util.*

object Voucher {
    private val voucherMap = mapOf(
        "HEMAT10" to DiskonPersen(10),
        "POTONG20K" to DiskonNominal(20_000),
        "NODISKON" to TanpaDiskon(),
        "BERTINGKAT" to DiskonBertingkat()
    )

    fun getDiskon(kode: String): Diskon {
        return voucherMap[kode] ?: TanpaDiskon()
    }
}
