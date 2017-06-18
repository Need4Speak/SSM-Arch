package com.pancake.entity;

import java.sql.Timestamp;

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

    public User() {
    }

    public User(String name, String password, long phoneNumber, String sex, Timestamp lastSignTime, int status) {
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.lastSignTime = lastSignTime;
        this.status = status;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (phoneNumber != user.phoneNumber) return false;
        if (status != user.status) return false;
        if (!name.equals(user.name)) return false;
        if (!password.equals(user.password)) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (!lastSignTime.equals(user.lastSignTime)) return false;
        return uniCode.equals(user.uniCode);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + lastSignTime.hashCode();
        result = 31 * result + status;
        result = 31 * result + uniCode.hashCode();
        return result;
    }
}
