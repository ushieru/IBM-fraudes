package com.ibm.academia.restapi.fraudes.models.dto

data class CurrencyInfo (
    val code: String,
    val name: String,
    val symbol: String,
    val eurRate: String
)