package com.ibm.academia.restapi.fraudes.clients

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "fixer", url = "http://data.fixer.io/")
interface FixerClient {
    @GetMapping("/api/latest?access_key={token}&symbols={symbols}")
    fun getEURRate(@PathVariable token: String, @PathVariable symbols: String): Map<String, Any>;
}