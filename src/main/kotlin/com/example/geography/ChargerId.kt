package com.example.geography

import java.io.Serializable

data class ChargerId(
    val stationId: String,
    val chargerId: String
) : Serializable
