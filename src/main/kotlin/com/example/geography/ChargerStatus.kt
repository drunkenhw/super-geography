package com.example.geography

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class ChargerStatus(
    @Id
    @Column(name = "station_id")
    val stationId: String,

    @Id
    @Column(name = "charger_id")
    val chargerId: String,

    @Column(length = 30)
    val latestUpdateTime: LocalDateTime?,

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    val chargerCondition: ChargerCondition
) {

    fun isAvailable(): Boolean {
        return chargerCondition.isStandBy()
    }

    fun isUsing(): Boolean {
        return chargerCondition == ChargerCondition.CHARGING_IN_PROGRESS
    }
}
