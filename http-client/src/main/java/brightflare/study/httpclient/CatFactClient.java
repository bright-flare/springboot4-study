package brightflare.study.httpclient;

import org.springframework.web.service.annotation.GetExchange;

interface CatFactClient {

  @GetExchange("https://catfact.ninja/fact")
  CatFact call();

}
