package com.example.demo

import com.example.demo.client.BoletoClient
import com.example.demo.model.Boleto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("demo")
class DemoController {

//    public Flux<Contato> getall() {
    //TODO código que retorne flux
//    }

    @GetMapping
    suspend fun getAll(): List<Boleto> = BoletoClient.getPagamentos()

}