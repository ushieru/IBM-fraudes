package com.ibm.academia.restapi.fraudes.clients

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "restcountries", url = "https://restcountries.com/")
interface RestCountriesClient {
    @GetMapping("/v2/name/{country}")
    fun getCurrencies(@PathVariable("country") country: String): List<Map<String, Any>>;
}