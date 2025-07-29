package brightflare.study.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Customer {
  
  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  public Customer() {
  }

  public Customer(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Customer customer)) return false;
    return Objects.equals(id, customer.id) && Objects.equals(name, customer.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
  
}
