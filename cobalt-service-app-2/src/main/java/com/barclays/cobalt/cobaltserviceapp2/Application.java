package com.barclays.cobalt.cobaltserviceapp2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {

  private static final Logger logger = LoggerFactory.getLogger(Application.class);
  private final Random random;

  public Application() {
    random = new Random();
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


  @GetMapping("/greet")
  public String hello(@RequestParam(defaultValue = "World!") final String who) throws InterruptedException {
    int random = this.random.nextInt();
    logger.info("Random value is : " + random);
    if (random > 0) {
      Thread.sleep(8000L);
    }
    return "Hello " + who;
  }
}
