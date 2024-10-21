package rous.space.rs.spaceshipms.domain;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="SPACESHIP")
public class Spaceship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String model;
}