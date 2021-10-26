package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Boleto(
    val id: Int,
    val idCliente: String,
    @JsonProperty("codAgBeneficiario") val ag: Int,
    @JsonProperty("codContaBeneficiario") val cc: String
)