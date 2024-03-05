package org.airplane_project.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="flight_route")
public class Flight_Route {
    @Id
    @Column(name="F_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int F_id;
    @Column(name="A_id")
    private int A_id;
    @Column(name="flight_date")
    private Date flight_date;
    @Column(name="dept_time")
    private Time dept_time;
    @Column(name="arr_time")
    private Time arr_time;
    @Column(name="price")
    private double price;
}
