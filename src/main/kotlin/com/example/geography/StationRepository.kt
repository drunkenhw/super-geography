package com.example.geography

import Station
import org.springframework.data.jpa.repository.JpaRepository

interface StationRepository : JpaRepository<Station, String> {


}
