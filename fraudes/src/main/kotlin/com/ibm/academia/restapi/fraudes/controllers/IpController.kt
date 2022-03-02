package com.ibm.academia.restapi.fraudes.controllers

import com.ibm.academia.restapi.fraudes.exceptions.BadRequest
import com.ibm.academia.restapi.fraudes.exceptions.NotFoundException
import com.ibm.academia.restapi.fraudes.models.dto.IPData
import com.ibm.academia.restapi.fraudes.services.ICurrencyRate
import com.ibm.academia.restapi.fraudes.services.IIPService
import com.ibm.academia.restapi.fraudes.services.IPDAO
import com.ibm.academia.restapi.fraudes.services.IRestCountries
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.core.env.Environment;

@RestController
@RequestMapping("/info")
class IpController @Autowired constructor(
    @Qualifier(value = "IpServiceFeignService")
    private val ipServiceFeign: IIPService,
    @Qualifier(value = "RestCountriesFeignService")
    private val restCountries: IRestCountries,
    @Qualifier(value = "CurrencyRateFeignService")
    private val currencyRate: ICurrencyRate,
    @Autowired
    private val ipdao: IPDAO,
    @Autowired
    private val enviroment: Environment,
) {
    @GetMapping("/{ip}")
    fun getIPInfo (@PathVariable("ip") ip: String): ResponseEntity<IPData> {
        val blackListIP = ipdao.findIPByIp(ip);
        if(blackListIP.isPresent) throw BadRequest("Ip en lista negra")
        val response = ipServiceFeign.getInfo(ip);
        if(response.name.isBlank() || response.countryCode.isBlank()) throw NotFoundException("IP no encontrada")
        val currencies = restCountries.getCurrencies(response.name);
        val currenciesWithRate = currencies.map { currencyRate.getRate(enviroment.getRequiredProperty("fixer.token"), it) }
        return ResponseEntity<IPData>(IPData(response, currenciesWithRate), HttpStatus.OK);
    }
}
