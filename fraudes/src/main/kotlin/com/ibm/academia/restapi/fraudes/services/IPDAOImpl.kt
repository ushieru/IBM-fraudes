package com.ibm.academia.restapi.fraudes.services

import com.ibm.academia.restapi.fraudes.exceptions.NotFoundException
import com.ibm.academia.restapi.fraudes.models.entities.IP
import com.ibm.academia.restapi.fraudes.repositories.BlackListIPRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class IPDAOImpl @Autowired constructor(
    private val blackListIPRepository: BlackListIPRepository,
) : IPDAO {

    @Transactional(readOnly = true)
    override fun findByID(id: Long): IP {
        val ip = blackListIPRepository.findById(id)
        if(!ip.isPresent) throw NotFoundException("IP no encontrada en blacklist")
        return ip.get()
    }

    @Transactional()
    override fun save(ip: IP): IP {
        return blackListIPRepository.save(ip)
    }

    @Transactional(readOnly = true)
    override fun findAll(): Iterable<IP> {
        return blackListIPRepository.findAll()
    }

    @Transactional()
    override fun deleteByID(id: Long) {
        blackListIPRepository.deleteById(id)
    }

    @Transactional(readOnly = true)
    override fun findIPByIp(ip: String): Optional<IP> {
        return blackListIPRepository.findIPByIp(ip)
    }
}