package com.ibm.academia.restapi.fraudes.models.dto

data class IPData (
    val countryInfo: CountryInfo,
    val currencyInfo: List<CurrencyInfo>
)