package com.abc.beans;

public class Sc {
    private String sid;
    private String cid;
    private double score;

    public Sc(String sid, String cid, double score) {
        this.sid = sid;
        this.cid = cid;
        this.score = score;
    }

    public Sc() {

    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Sc{" +
                "sid='" + sid + '\'' +
                ", cid='" + cid + '\'' +
                ", score=" + score +
                '}';
    }
}
