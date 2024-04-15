package org.highfives.esc;

import org.highfives.esc.crawling.service.ExamCrawler;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EscApplication implements CommandLineRunner {

    private final ExamCrawler crawler;

    @Autowired
    public EscApplication(ExamCrawler crawler) {
        this.crawler = crawler;
    }

    public static void main(String[] args) {
        SpringApplication.run(EscApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() { return new ModelMapper(); }

    @Override
    public void run(String... args) throws Exception {
//        crawler.CrawlingToeic();
//        crawler.CrawlingToeicSpeaking();
//        crawler.CrawlingOpic();
    }
}
