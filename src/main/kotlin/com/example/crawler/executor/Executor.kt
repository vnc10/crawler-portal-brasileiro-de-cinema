package com.example.crawler.executor

import com.example.crawler.service.DownloadImageService
import com.example.crawler.utils.Converter.Companion.convertURLToPageURL
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Executor : CommandLineRunner {

    @Autowired
    private lateinit var downloadImageService: DownloadImageService

    override fun run(vararg args: String?) {

        val urls = listOf(
            "https://web.archive.org/web/20240225224329/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao1/edicao1",
            "https://web.archive.org/web/20240914212421/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao2/edicao2",
            "https://web.archive.org/web/20240225215749/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao3/edicao3",
            "https://web.archive.org/web/20241210165642/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao1976-3A/edicao",
            "https://web.archive.org/web/20250125203649/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao1976-4/edicao",
            "https://web.archive.org/web/20241012221111/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao1976-5/edicao",
            "https://web.archive.org/web/20240225203238/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao6/edicao6",
            "https://web.archive.org/web/20241012225154/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao7/edicao7",
            "https://web.archive.org/web/20250125184706/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao1976-ano2-extra/edicao",
            "https://web.archive.org/web/20241210180650/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao9/edicao9",
            "https://web.archive.org/web/20241110210535/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao10/edicao10",
            "https://web.archive.org/web/20240225224253/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao1976-11/edicao",
            "https://web.archive.org/web/20241012210533/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao1977-13/edicao",
            "https://web.archive.org/web/20241210171120/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao1976/edicao1976",
            "https://web.archive.org/web/20241110212324/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao14/edicao",
            "https://web.archive.org/web/20240225230748/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao1977-15/edicao",
            "https://web.archive.org/web/20240914215952/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao1977-16/edicao",
            "https://web.archive.org/web/20240810175633/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao1977-17/edicao",
            "https://web.archive.org/web/20240225222702/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao1977-anuario/edicao",
            "https://web.archive.org/web/20241210182719/https://portalbrasileirodecinema.com.br/cinemaemcloseup/edicao1979-18/edicao"
        )
        urls.map {
            for (i in 1 until 100) {
                val convert = convertURLToPageURL(it, i)

                downloadImageService.downloadImage(convert, i)
            }
        }
    }
}