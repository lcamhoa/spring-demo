package tutorial.spring.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private
    Long id;

    @Column(nullable = false)
    private
    String name;

    private String role;
}
