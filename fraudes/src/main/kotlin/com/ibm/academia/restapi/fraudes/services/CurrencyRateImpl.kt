package com.ibm.academia.restapi.fraudes.services

import com.ibm.academia.restapi.fraudes.clients.FixerClient
import com.ibm.academia.restapi.fraudes.models.dto.CountryInfo
import com.ibm.academia.restapi.fraudes.models.dto.CurrencyInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("CurrencyRateFeignService")
class CurrencyRateImpl @Autowired constructor(
    val fixerClient: FixerClient
): ICurrencyRate {
    override fun getRate(token: String, codes: String): Map<String, Double> {
        val response = fixerClient.getEURRate(token, codes);
        val rates = response["rates"] as Map<String, Double>;
        return rates
    }
}