package com.example.crawler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class CrawlerApplication

fun main(args: Array<String>) {
	runApplication<CrawlerApplication>(*args)
}
