package com.example.crawler.client

import com.example.crawler.config.WebArchiveClientConfig
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "webArchive", url = "https://portalbrasileirodecinema.com.br/cinemaemcloseup/", configuration = [WebArchiveClientConfig::class])
interface WebArchive {

    @GetMapping(value = ["{url}"], produces = ["image/jpeg"])
    fun getImage(@PathVariable("url") url: String): ResponseEntity<ByteArray>
}