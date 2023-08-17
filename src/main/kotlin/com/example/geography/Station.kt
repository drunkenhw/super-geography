
import com.example.geography.Charger
import com.example.geography.Coordinate
import jakarta.persistence.*

@Entity
@Table(name = "charge_station", indexes = [Index(name = "idx_station_coordination", columnList = "latitude, longitude, stationId")])
class Station(
    @Id
    val stationId: String,

    @Column(nullable = false, length = 120)
    val stationName: String,

    @Column(nullable = false, length = 70)
    val companyName: String,

    @Column(nullable = false, length = 200)
    val address: String,

    @Column(nullable = false, length = 5)
    val isParkingFree: Boolean,

    @Column(nullable = false, length = 70)
    val operatingTime: String,

    @Column(nullable = false, length = 200)
    val detailLocation: String,

    @Embedded
    val coordinate: Coordinate,

    @Column(nullable = false, length = 5)
    val isPrivate: Boolean,

    @Column(nullable = false, length = 50)
    val contact: String,

    @Column(length = 200)
    val stationState: String,

    @Column(length = 100)
    val privateReason: String,

    @OneToMany(mappedBy = "station", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    val chargers: MutableList<Charger> = ArrayList(),

    ) {

    fun getTotalCount(): Int {
        return chargers.size
    }

    fun getAvailableCount(): Int {
        return chargers.count { it.isAvailable() }
    }
}
