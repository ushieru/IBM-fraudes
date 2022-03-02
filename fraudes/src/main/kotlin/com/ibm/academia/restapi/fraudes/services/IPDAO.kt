package com.ibm.academia.restapi.fraudes.services

import com.ibm.academia.restapi.fraudes.models.entities.IP
import java.util.*

interface IPDAO {
    fun findByID(id: Long) : IP
    fun save(ip: IP): IP
    fun findAll(): Iterable<IP>
    fun deleteByID(id: Long)
    fun findIPByIp(ip: String): Optional<IP>;
}