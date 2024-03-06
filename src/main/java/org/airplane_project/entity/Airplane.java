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

    public Airplane(int a_id, String name, int capacity) {
        A_id = a_id;
        this.name = name;
        this.capacity = capacity;
    }

    public Airplane() {

    }

    public int getA_id() {
        return A_id;
    }

    public void setA_id(int a_id) {
        A_id = a_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "A_id=" + A_id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
