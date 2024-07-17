package com.example.a30daysofwellness.model;

public class Day30 {
    int imgid;
    String name;
    String desc;
    String longdesc;



    public Day30(int imgid, String name, String desc, String longdesc) {
        this.imgid = imgid;
        this.name = name;
        this.desc = desc;
        this.longdesc = longdesc;
    };

    public int getImgid() {
        return imgid;
    }
    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }
    public String getLongdesc() {
        return longdesc;
    }
}
