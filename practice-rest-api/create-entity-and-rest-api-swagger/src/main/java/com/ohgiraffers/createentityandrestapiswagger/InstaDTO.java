package com.ohgiraffers.createentityandrestapiswagger;

import java.time.LocalDateTime;

public class InstaDTO {

    private int registNo;
    private LocalDateTime enrollDate;
    private int likedNumber;
    private String description;
    private String status;

    public InstaDTO() {
    }

    public InstaDTO(int registNo, LocalDateTime enrollDate, int likedNumber, String description, String status) {
        this.registNo = registNo;
        this.enrollDate = enrollDate;
        this.likedNumber = likedNumber;
        this.description = description;
        this.status = status;
    }

    public int getRegistNo() {
        return registNo;
    }

    public void setRegistNo(int registNo) {
        this.registNo = registNo;
    }

    public LocalDateTime getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDateTime enrollDate) {
        this.enrollDate = enrollDate;
    }

    public int getLikedNumber() {
        return likedNumber;
    }

    public void setLikedNumber(int likedNumber) {
        this.likedNumber = likedNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InstaDTO{" +
                "registNo=" + registNo +
                ", enrollDate=" + enrollDate +
                ", likedNumber=" + likedNumber +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
