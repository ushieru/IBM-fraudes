package com.ibm.academia.restapi.fraudes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class FraudesApplication

fun main(args: Array<String>) {
	runApplication<FraudesApplication>(*args)
}
