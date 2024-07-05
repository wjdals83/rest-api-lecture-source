package com.ohgiraffers.createentityandrestapiswagger;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "entityInsta")
@Table(name = "tbl_insta")
public class Insta {

    @Id
    @Column(name = "regist_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registNo;

    @Column(name = "enroll_date", nullable = false)
    public LocalDateTime enrollDate;

    @Column(name = "liked_number", nullable = false)
    private int likedNumber;

    @Column(name = "description", nullable = false, length = 500)
    public String description;

    @Column(name = "status", columnDefinition = "char(1) default 'Y'")
    public String status;

    protected Insta() {}

    public Insta(int registNo, LocalDateTime enrollDate, int likedNumber, String description, String status) {
        this.registNo = registNo;
        this.enrollDate = enrollDate;
        this.likedNumber = likedNumber;
        this.description = description;
        this.status = status;
    }

    public int getRegistNo() {
        return registNo;
    }

    public LocalDateTime getEnrollDate() {
        return enrollDate;
    }

    public int getLikedNumber() {
        return likedNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Insta{" +
                "registNo=" + registNo +
                ", enrollDate=" + enrollDate +
                ", likedNumber=" + likedNumber +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
