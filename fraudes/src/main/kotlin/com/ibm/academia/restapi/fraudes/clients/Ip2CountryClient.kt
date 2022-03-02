package com.ibm.academia.restapi.fraudes.clients

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "ip2country", url = "https://api.ip2country.info/")
interface Ip2CountryClient {
    @GetMapping("/ip?{ip}")
    fun getCountryFromIP(@PathVariable("ip") ip: String): Map<String, String>
}