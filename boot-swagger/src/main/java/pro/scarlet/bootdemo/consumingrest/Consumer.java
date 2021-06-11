package pro.scarlet.bootdemo.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
// @SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    // Boot Main Method 不出现两次 注释掉
    // 下面两个Bean会随着Bootdemo里的main方法进行加载
    // 如果加载失败（比如说网络不好时），就会导致服务器启动失败
    // public static void main(String[] args) {
    //     SpringApplication.run(Consumer.class, args);
    // }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote.class);
            log.info(quote.toString());
        };
    }

    @GetMapping("/quote")
    public Quote quote() {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote.class);
        log.info(quote.toString());
        return quote;
    }
}
