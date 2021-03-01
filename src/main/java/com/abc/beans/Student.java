package com.abc.beans;

import java.util.Set;

public class Student {
    private String sid;
    private String sname;
    private String password;
    private String sex;
    private String tel;
    private String school;
    private String garde;
    private String address;
    private int age;
    private String education;
    private Set<Course> courses;
    public Student() {
    }

    public Student(String sid, String sname, String password, String sex, String tel, String school, String garde, String address, int age, String education) {
        this.sid = sid;
        this.sname = sname;
        this.password = password;
        this.sex = sex;
        this.tel = tel;
        this.school = school;
        this.garde = garde;
        this.address = address;
        this.age = age;
        this.education = education;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGarde() {
        return garde;
    }

    public void setGarde(String garde) {
        this.garde = garde;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", school='" + school + '\'' +
                ", garde='" + garde + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                '}';
    }
}
