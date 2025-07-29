package brightflare.study.httpclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
class CatFactRestClient {

  private final RestClient http;

  public CatFactRestClient(RestClient.Builder builder) {
    this.http = builder.build();
  }

  CatFact call() {
    return http.get()
            .uri("https://catfact.ninja/fact")
            .retrieve()
            .body(CatFact.class);
  }
}
