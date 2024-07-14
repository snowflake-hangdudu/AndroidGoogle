package com.example.list2;

public class Item {

    private int imageId;
    private String title;
    private String num;

    public Item(int imageId, String title, String num) {
        this.imageId = imageId;
        this.title = title;
        this.num = num;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }




}
