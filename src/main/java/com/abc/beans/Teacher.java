package com.abc.beans;

import java.util.Set;

public class Teacher {
    private String tid;
    private String tname;
    private String password;
    private String sex;
    private String tel;
    private String school;
    private int worktime;
    private String address;
    private int age;
    private String education;
    private Set<Student> students;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    public Teacher(String tid, String tname, String school, int age, String tel, String education, String sex, String address, int worktime, Set<Student> students) {
        this.tid = tid;
        this.tname = tname;
        this.school = school;
        this.age = age;
        this.tel = tel;
        this.education = education;
        this.sex = sex;
        this.address = address;
        this.worktime = worktime;
        this.students = students;
    }
    public Teacher(String tid, String tname, String password, String sex, String tel, String school, int worktime, String address, int age, String education) {
        this.tid = tid;
        this.tname = tname;
        this.password = password;
        this.sex = sex;
        this.tel = tel;
        this.school = school;
        this.worktime = worktime;
        this.address = address;
        this.age = age;
        this.education = education;
    }

    public Teacher() {
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
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

    public int getWorktime() {
        return worktime;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", school='" + school + '\'' +
                ", worktime=" + worktime +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                '}';
    }
}
