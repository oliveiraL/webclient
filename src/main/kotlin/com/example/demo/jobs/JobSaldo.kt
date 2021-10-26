package com.example.demo.jobs

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class JobSaldo {

    @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
    fun verificarValidacoesPendentes() {
        println("Olha eu aqui de novo")
    }

}