package com.ibm.academia.restapi.fraudes.services

import com.ibm.academia.restapi.fraudes.models.dto.CountryInfo
import com.ibm.academia.restapi.fraudes.models.dto.CurrencyInfo

interface ICurrencyRate {
    fun getRate(token: String, currencyInfo: CurrencyInfo): CurrencyInfo;
}