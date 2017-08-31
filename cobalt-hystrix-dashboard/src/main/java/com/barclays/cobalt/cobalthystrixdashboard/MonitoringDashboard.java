package com.barclays.cobalt.cobalthystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableHystrixDashboard
@Controller
@EnableTurbine
@EnableEurekaClient
public class MonitoringDashboard {

  public static void main(String[] args) {
    SpringApplication.run(MonitoringDashboard.class, args);
  }


  @GetMapping("/")
  public String hystrix() {
    return "forward:/hystrix";
  }

}
