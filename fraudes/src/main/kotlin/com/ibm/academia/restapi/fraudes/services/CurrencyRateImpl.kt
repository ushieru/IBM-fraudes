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
    override fun getRate(token: String, currencyInfo: CurrencyInfo): CurrencyInfo {
        val response = fixerClient.getEURRate(token, currencyInfo.code);
        val rates = response["rates"] as Map<String, Double>;
        val rate =  rates[currencyInfo.code] ?: 0.0
        return CurrencyInfo(
            currencyInfo.code,
            currencyInfo.name,
            currencyInfo.symbol,
            rate.toString()
        )
    }
}