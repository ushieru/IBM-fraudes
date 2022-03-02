package com.ibm.academia.restapi.fraudes.services

import com.ibm.academia.restapi.fraudes.clients.RestCountriesClient
import com.ibm.academia.restapi.fraudes.models.dto.CurrencyInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("RestCountriesFeignService")
class RestCountriesFeignImpl @Autowired constructor(
    private val restCountriesClient: RestCountriesClient
): IRestCountries {
    override fun getCurrencies(countryName: String): List<CurrencyInfo> {
        val response = restCountriesClient.getCurrencies(countryName)
        val currencies = response[0]["currencies"] as List<Map<String, String>>
        return currencies.map { CurrencyInfo( it["code"] ?: "", it["name"] ?: "", it["symbol"] ?: "", "") }
    }
}

