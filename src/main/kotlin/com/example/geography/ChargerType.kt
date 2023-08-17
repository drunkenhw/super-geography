package com.example.geography

import java.math.BigDecimal

enum class ChargerType(val typeNumber: String, val defaultCapacity: BigDecimal) {
    DC_FAST("01", BigDecimal.valueOf(100)),
    AC_SLOW("02", BigDecimal.valueOf(7)),
    DC_AC_3PHASE("03", BigDecimal.valueOf(100)),
    DC_COMBO("04", BigDecimal.valueOf(100)),
    DC_DC_COMBO("05", BigDecimal.valueOf(50)),
    DC_AC_DC_COMBO("06", BigDecimal.valueOf(50)),
    AC_3PHASE("07", BigDecimal.valueOf(7));

    companion object {
        fun from(input: String): ChargerType {
            return values().find { it.typeNumber == input } ?: AC_SLOW
        }
    }
}
