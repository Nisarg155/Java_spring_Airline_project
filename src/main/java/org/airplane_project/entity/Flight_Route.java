package org.airplane_project.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name="flight_route")
public class Flight_Route {
    @Id
    @Column(name="f_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int f_id;


    @ManyToOne
    @JoinColumn(name="a_id")
    private Airplane a_id;
    @OneToMany(mappedBy = "f_id",cascade = CascadeType.ALL)
    private List<Ticket> tickets ;


    @Column(name="arr_city",nullable = false)
    private String arr_city;
    @Column(name="dest_city",nullable = false)
    private String dest_city;
    @Column(name="flight_date",nullable = false)
    private Date flight_date;
    @Column(name="dept_time",nullable = false)
    private Time dept_time;
    @Column(name="arr_time",nullable = false)
    private Time arr_time;
    @Column(name="price",nullable = false)
    private double price;


    public Flight_Route(Airplane a_id,String arr_city, String dest_city, Date flight_date, Time dept_time, Time arr_time, double price) {
        this.a_id = a_id;

        this.arr_city = arr_city;
        this.dest_city = dest_city;
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

    public String getArr_city() {
        return arr_city;
    }

    public String getDest_city() {
        return dest_city;
    }

    public void setArr_city(String arr_city) {
        this.arr_city = arr_city;
    }

    public void setDest_city(String dest_city) {
        this.dest_city = dest_city;
    }

    @Override
    public String toString() {
        return "Flight_Route{" +
                "f_id=" + f_id +
                ", a_id=" + a_id +
                ", arr_city='" + arr_city + '\'' +
                ", dest_city='" + dest_city + '\'' +
                ", flight_date=" + flight_date +
                ", dept_time=" + dept_time +
                ", arr_time=" + arr_time +
                ", price=" + price +
                '}';
    }

}
