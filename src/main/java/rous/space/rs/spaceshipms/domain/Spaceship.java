package rous.space.rs.spaceshipms.domain;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="SPACESHIP")
public class Spaceship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    private String name;
    private String model;

    public Spaceship(String name, String model) {
        this.name = name;
        this.model = model;
    }


}