package com.example.crawler.service

import com.example.crawler.client.WebArchive
import com.example.crawler.executor.Executor
import com.example.crawler.utils.Converter.Companion.extractEdition
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

@Service
class DownloadImageService(
    private val webArchive: WebArchive
) {
    fun downloadImage(url: String, pageNumber: Int) {
        println("https://portalbrasileirodecinema.com.br/cinemaemcloseup/$url")

        var response: ResponseEntity<ByteArray>

        try {
            response = webArchive.getImage(url)
        } catch (e: Exception) {
            return
        }

        if (response.statusCode.is2xxSuccessful) {
            val imageBytes = response.body ?: return
            val directoryPath = Paths.get(extractEdition(url).toString())
            Files.createDirectories(directoryPath)

            val filePath = directoryPath.resolve("$pageNumber.jpg")

            Files.write(filePath, imageBytes, StandardOpenOption.CREATE)
            println("✅ Imagem salva em: ${filePath.toAbsolutePath()}")
        } else {
            println("❌ Erro ao baixar a imagem: ${response.statusCode}")
            return
        }
    }
}