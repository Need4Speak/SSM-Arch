package com.pancake.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by chao on 2017/6/13.
 */
public class User {
    private long id;
    private String name;
    private String password;
    private long phoneNumber;
    private String sex;
    private Timestamp lastSignTime;
    private int status;
    private String uniCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Timestamp getLastSignTime() {
        return lastSignTime;
    }

    public void setLastSignTime(Timestamp lastSignTime) {
        this.lastSignTime = lastSignTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUniCode() {
        return uniCode;
    }

    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", sex='" + sex + '\'' +
                ", lastSignTime=" + lastSignTime +
                ", status=" + status +
                ", uniCode='" + uniCode + '\'' +
                '}';
    }
}
