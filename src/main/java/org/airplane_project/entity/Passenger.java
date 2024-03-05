package org.airplane_project.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name="passenger")
public class Passenger {
    @Id
    @Column(name="p_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int p_id ;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private int phone;

}
