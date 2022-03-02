package com.ibm.academia.restapi.fraudes.services

import org.springframework.stereotype.Service
import com.ibm.academia.restapi.fraudes.clients.Ip2CountryClient;
import com.ibm.academia.restapi.fraudes.models.dto.CountryInfo
import org.springframework.beans.factory.annotation.Autowired

@Service("IpServiceFeignService")
class IPServiceFeign @Autowired constructor(
    private val ip2CountryClient: Ip2CountryClient
) : IIPService {

    override fun getInfo(ip: String): CountryInfo {
        val response = ip2CountryClient.getCountryFromIP(ip)
        val countryCode3 = response["countryCode3"] ?: ""
        val countryName = response["countryName"] ?: ""
        return CountryInfo(countryName, countryCode3 )
    }
}