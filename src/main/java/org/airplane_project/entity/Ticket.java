package org.airplane_project.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    @Column(name="T_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int T_id;
    @ManyToOne
    @JoinColumn(name="P_id")
    private Passenger P_id;
    @ManyToOne
    @JoinColumn(name="F_id")
    private Flight_Route F_id;
    @Column(name="booking_date",nullable = false)
    private Date booking_date;
    @Column(name="seat_no",nullable = false)
    private int seat_no;

    public Ticket(int t_id, Passenger p_id, Flight_Route f_id, Date booking_date, int seat_no) {
        T_id = t_id;
        P_id = p_id;
        F_id = f_id;
        this.booking_date = booking_date;
        this.seat_no = seat_no;
    }

    public Ticket() {

    }

    public int getT_id() {
        return T_id;
    }

    public void setT_id(int t_id) {
        T_id = t_id;
    }

    public Passenger getP_id() {
        return P_id;
    }

    public void setP_id(Passenger p_id) {
        P_id = p_id;
    }

    public Flight_Route getF_id() {
        return F_id;
    }

    public void setF_id(Flight_Route f_id) {
        F_id = f_id;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public int getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(int seat_no) {
        this.seat_no = seat_no;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "T_id=" + T_id +
                ", P_id=" + P_id +
                ", F_id=" + F_id +
                ", booking_date=" + booking_date +
                ", seat_no=" + seat_no +
                '}';
    }
}
