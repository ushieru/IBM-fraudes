package com.ibm.academia.restapi.fraudes.exceptions.handler

import com.ibm.academia.restapi.fraudes.exceptions.BadRequest
import com.ibm.academia.restapi.fraudes.exceptions.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionsHandler {
    @ExceptionHandler(value = [NotFoundException::class])
    fun noEncontrado(notFoundException: NotFoundException): ResponseEntity<Map<String, String>>{
        val exception = notFoundException.message ?: "Dato no encontrado"
        return ResponseEntity(mapOf("Error" to exception), HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler(value = [BadRequest::class])
    fun peticionInvalida(notFoundException: BadRequest): ResponseEntity<Map<String, String>>{
        val exception = notFoundException.message ?: "Peticion invalida"
        return ResponseEntity(mapOf("Error" to exception), HttpStatus.BAD_REQUEST)
    }
}