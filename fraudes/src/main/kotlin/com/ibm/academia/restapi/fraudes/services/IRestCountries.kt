package com.ibm.academia.restapi.fraudes.services

import com.ibm.academia.restapi.fraudes.models.dto.CurrencyInfo

interface IRestCountries {
    fun getCurrencies(countryName: String): List<CurrencyInfo>
}