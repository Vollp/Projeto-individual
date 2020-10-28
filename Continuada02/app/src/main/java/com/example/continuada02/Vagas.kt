package com.example.continuada02

import java.math.BigDecimal

data class Vagas (
    val id:Int,
    val nomeEmpresa:String,
    val cargo:String,
    val vagas:Int,
    val endereco:String,
    val salario: BigDecimal
)