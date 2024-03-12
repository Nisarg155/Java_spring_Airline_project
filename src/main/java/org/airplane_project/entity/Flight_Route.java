package org.airplane_project.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="flight_route")
public class Flight_Route {
    @Id
    @Column(name="f_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int f_id;
    @JoinColumn(name="a_id")
    @OneToOne
    private Airplane a_id;
    @Column(name="flight_date",nullable = false)
    private Date flight_date;
    @Column(name="dept_time",nullable = false)
    private Time dept_time;
    @Column(name="arr_time",nullable = false)
    private Time arr_time;
    @Column(name="price",nullable = false)
    private double price;

    public Flight_Route(int f_id, Airplane a_id, Date flight_date, Time dept_time, Time arr_time, double price) {
        this.f_id = f_id;
        this.a_id = a_id;
        this.flight_date = flight_date;
        this.dept_time = dept_time;
        this.arr_time = arr_time;
        this.price = price;
    }

    public Flight_Route() {

    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public Airplane getA_id() {
        return this.a_id;
    }

    public void setA_id(Airplane a_id) {
        this.a_id = a_id;
    }

    public Date getFlight_date() {
        return flight_date;
    }

    public void setFlight_date(Date flight_date) {
        this.flight_date = flight_date;
    }

    public Time getDept_time() {
        return dept_time;
    }

    public void setDept_time(Time dept_time) {
        this.dept_time = dept_time;
    }

    public Time getArr_time() {
        return arr_time;
    }

    public void setArr_time(Time arr_time) {
        this.arr_time = arr_time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight_Route{" +
                "F_id=" + f_id +
                ", A_id=" + a_id +
                ", flight_date=" + flight_date +
                ", dept_time=" + dept_time +
                ", arr_time=" + arr_time +
                ", price=" + price +
                '}';
    }
}
