package brightflare.study.httpclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(group = "cats", types = {CatFactClient.class})
public class ClientsConfiguration {
  
  @Bean
  public RestClientHttpServiceGroupConfigurer configurer() {
    return groups -> groups.filterByName("cats").forEachClient(
            (group, clientBuilder) -> clientBuilder
                    .baseUrl("https://catfact.ninja")
                    .defaultHeader("User-Agent", "BrightFlare Study HttpClient")
    );
  }
  
}
