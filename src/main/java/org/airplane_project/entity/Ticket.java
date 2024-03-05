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
    @Column(name="P_id")
    private int P_id;
    @Column(name="F_id")
    private int F_id;
    @Column(name="booking_date")
    private Date booking_date;
    @Column(name="seat_no")
    private int seat_no;

}
