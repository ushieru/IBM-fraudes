package com.ibm.academia.restapi.fraudes.services

import com.ibm.academia.restapi.fraudes.models.dto.CountryInfo

interface IIPService {
    fun getInfo(ip: String): CountryInfo
}