package com.example.geography

enum class ChargerCondition (val value: Int) {
    COMMUNICATION_ERROR(1),
    STANDBY(2),
    CHARGING_IN_PROGRESS(3),
    OPERATION_SUSPENDED(4),
    UNDER_INSPECTION(5),
    STATUS_UNKNOWN(9);

    companion object {
        fun from(input: Int): ChargerCondition {
            return values().find { it.value == input } ?: STATUS_UNKNOWN
        }

        fun from(input: String): ChargerCondition {
            return values().find { it.value == input[0].toInt() - '0'.toInt() } ?: STATUS_UNKNOWN
        }
    }

    fun isStandBy(): Boolean {
        return this == STANDBY
    }
}
