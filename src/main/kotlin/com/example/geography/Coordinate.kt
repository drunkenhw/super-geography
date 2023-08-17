package com.example.geography

import jakarta.persistence.Embeddable
import org.springframework.data.geo.Point

@Embeddable
class Coordinate(
    val point: Point
) {
}
