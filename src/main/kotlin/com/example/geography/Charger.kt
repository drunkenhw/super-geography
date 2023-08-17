package com.example.geography

import Station
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@IdClass(ChargerId::class)
@Table(name = "charger")
class Charger(
    @Id
    @Column(name = "station_id")
    val stationId: String,

    @Id
    @Column(name = "charger_id")
    val chargerId: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    val type: ChargerType,

    val price: BigDecimal?,

    @Column(scale = 2)
    val capacity: BigDecimal?,

    @Column(length = 15)
    val method: String,

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumns(
        JoinColumn(name = "station_id"),
        JoinColumn(name = "charger_id")
    )
    val chargerStatus: ChargerStatus?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id", insertable = false, updatable = false, foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    val station: Station?
)  {

    fun isAvailable(): Boolean {
        return chargerStatus?.isAvailable() ?: false
    }

    fun isQuick(): Boolean {
        val capacity = capacity ?: type.defaultCapacity
        return capacity >= OUTPUT_THRESHOLD
    }

    fun getCapacity(): BigDecimal {
        return capacity ?: type.defaultCapacity
    }

    fun isUpdated(charger: Charger): Boolean {
        return type != charger.type ||
                (capacity != null && capacity.compareTo(charger.capacity) != 0) ||
                method != charger.method
    }

    companion object {
        private val OUTPUT_THRESHOLD = BigDecimal.valueOf(50)
    }
}
