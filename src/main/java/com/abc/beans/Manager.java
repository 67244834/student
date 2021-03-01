package com.abc.beans;

public class Manager {
    private String mid;
    private String mname;
    private String password;
    private String sex;
    private int age;
    private String tel;
    private String position;

    public Manager() {
    }

    public Manager(String mname, String sex, int age, String tel, String position) {
        this.mname = mname;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.position = position;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mid='" + mid + '\'' +
                ", mname='" + mname + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
