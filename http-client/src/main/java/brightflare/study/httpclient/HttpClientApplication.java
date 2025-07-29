package brightflare.study.httpclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
  
//  @Bean
//  public CatFactClient catFactClientInterface(RestClient.Builder builder) {
//    return HttpServiceProxyFactory
//            .builder()
//            .exchangeAdapter(RestClientAdapter.create(builder.build()))
//            .build()
//            .createClient(CatFactClient.class);
//  }
  
  @Bean
  ApplicationRunner runCatFactRestClient(CatFactRestClient client) {
    return args -> System.out.println(client.call());
  }
  
  @Bean
  ApplicationRunner runCatFactClient(CatFactClient client) {
    return args -> System.out.println(client.call());
  }
  
}

