package com.startwithjava.simpleblog.entities;
import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Data
public class City implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;
    
    @Column(nullable = false)
    private String country;

    protected City() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }

    public City(String name, String state) {
        this.name = name;
        this.country = country;
    }
}
