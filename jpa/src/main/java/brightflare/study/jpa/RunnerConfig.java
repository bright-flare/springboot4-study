package brightflare.study.jpa;

import jakarta.persistence.EntityManager;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class RunnerConfig {


  /*
   * 학습 포인트 !
   * EntityManager를 @Autowired를 사용해 주입받을 수 있다.
   * 과거에는 스레드 안정성때문에 지양하였지만 , 이제부터는 사용 가능함. 
   */
  @Bean
  ApplicationRunner runner(EntityManager em, CustomerRepository customerRepository) {
    return args -> {

      customerRepository.deleteAll();
      Set.of("Alice", "Bob", "Charlie").forEach(name -> customerRepository.save(new Customer(name)));
      
      em.createQuery("select c from Customer c").getResultList().forEach(System.out::println);
//      customerRepository.findAll().forEach(System.out::println);
      
    };

  }
  
}
