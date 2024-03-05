package org.airplane_project.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;

@Entity
@Table(name="airplane")
public class Airplane {
    @Id
    @Column(name="A_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int A_id;
    @Column(name="name")
    private String name;
    @Column(name="capacity")
    private int capacity;
}
