package com.example.crawler.config

import feign.Retryer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WebArchiveClientConfig {

    @Bean
    fun retryer(): Retryer {
        return Retryer.Default(1_000L, 2_000L, 10)
    }
}