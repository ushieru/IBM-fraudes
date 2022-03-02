package com.ibm.academia.restapi.fraudes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

//@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
class FraudesApplication

fun main(args: Array<String>) {
	runApplication<FraudesApplication>(*args)
}
