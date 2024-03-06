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
    @Column(name="name",length = 100 , nullable = false)
    private String name;
    @Column(name="email",length = 100, nullable = false)
    private String email;
    @Column(name="phone",length = 10,nullable = false)
    private int phone;

    public Passenger(int p_id, String name, String email, int phone) {
        this.p_id = p_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Passenger() {

    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "p_id=" + p_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
