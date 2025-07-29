package brightflare.study.httpclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class HttpClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(HttpClientApplication.class, args);
  }

  @Bean
  public RestClient.Builder builder() {
    return RestClient.builder();
  }
  
  @Bean
  ApplicationRunner runner(CatFactClient client) {
    return args -> System.out.println(client.call());
  }
  
}

@Component
class CatFactClient {
  
  private final RestClient http;

  public CatFactClient(RestClient.Builder builder) {
    this.http = builder.build();
  }
  
  CatFact call() {
    return http.get()
            .uri("https://catfact.ninja/fact")
            .retrieve()
            .body(CatFact.class);
  }
}

record CatFact(String fact, int length) {}
