package com.example.crawler.utils

class Converter {
    companion object {
        fun convertURLToPageURL(originalUrl: String, pageNumber: Int): String {
            val urlWithoutPrefix = originalUrl.removePrefix("https://web.archive.org/web/")
            val cleanedUrl = urlWithoutPrefix.substringAfter("https://")
            val parts = cleanedUrl.split("/").dropLast(1)
            val edition = parts.last()

            return "$edition/pages/$pageNumber.jpg"
        }

        fun extractEdition(url: String): String? {
            val regex = """edicao(\d+[-\w]*)""".toRegex()
            val matchResult = regex.find(url)

            return matchResult?.groupValues?.get(0)
        }
    }
}