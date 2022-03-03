package com.ibm.academia.restapi.fraudes.controllers

import com.ibm.academia.restapi.fraudes.exceptions.BadRequest
import com.ibm.academia.restapi.fraudes.exceptions.NotFoundException
import com.ibm.academia.restapi.fraudes.models.dto.CurrencyInfo
import com.ibm.academia.restapi.fraudes.models.dto.IPData
import com.ibm.academia.restapi.fraudes.models.entities.IP
import com.ibm.academia.restapi.fraudes.services.ICurrencyRate
import com.ibm.academia.restapi.fraudes.services.IIPService
import com.ibm.academia.restapi.fraudes.services.IPDAO
import com.ibm.academia.restapi.fraudes.services.IRestCountries
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
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
    @GetMapping("/info/{ip}")
    fun getIPInfo (@PathVariable("ip") ip: String): ResponseEntity<IPData> {
        val blackListIP = ipdao.findIPByIp(ip);
        if(blackListIP.isPresent) throw BadRequest("Ip en lista negra")
        val response = ipServiceFeign.getInfo(ip);
        if(response.name.isBlank() || response.countryCode.isBlank()) throw NotFoundException("IP no encontrada")
        val currencies = restCountries.getCurrencies(response.name);
        val currenciesCodes = currencies.joinToString(separator = ",") { it.code }
        val rates = currencyRate.getRate(enviroment.getRequiredProperty("fixer.token"), currenciesCodes)
        val currenciesWitRate = currencies.map { CurrencyInfo(it.code, it.name, it.symbol, rates[it.code].toString()) }
        return ResponseEntity<IPData>(IPData(response, currenciesWitRate), HttpStatus.OK);
    }

    @PostMapping("/addBlackList")
    fun postIP (@RequestBody ip: IP): ResponseEntity<IP> {
        ipdao.save(ip)
        return ResponseEntity<IP>(ip, HttpStatus.OK);
    }
}
