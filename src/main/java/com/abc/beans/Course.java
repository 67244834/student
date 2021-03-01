package com.abc.beans;

import java.util.Set;

public class Course {
    private String cid;
    private String cname;
    private String tid;
    private Set<Teacher> teachers;
    private double score;

    public Course() {
    }

    public Course(String cid, String cname, String tid) {
        this.cid = cid;
        this.cname = cname;
        this.tid = tid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", tid='" + tid + '\'' +
                ", score=" + score +
                '}';
    }
}