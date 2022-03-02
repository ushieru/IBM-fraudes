package com.ibm.academia.restapi.fraudes.repositories

import com.ibm.academia.restapi.fraudes.models.entities.IP
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BlackListIPRepository: CrudRepository<IP, Long> {
    fun findIPByIp(ip: String): Optional<IP>;
}