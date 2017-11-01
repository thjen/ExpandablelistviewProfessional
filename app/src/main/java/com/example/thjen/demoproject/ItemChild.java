package com.example.thjen.demoproject;

public class ItemChild {

    private String sChild1;
    private int iChild1;
    private String sChild2;

    public ItemChild(String sChild1, int iChild1, String sChild2) {
        this.sChild1 = sChild1;
        this.iChild1 = iChild1;
        this.sChild2 = sChild2;
    }

    public String getsChild2() {
        return sChild2;
    }

    public void setsChild2(String sChild2) {
        this.sChild2 = sChild2;
    }

    public int getiChild1() {
        return iChild1;
    }

    public void setiChild1(int iChild1) {
        this.iChild1 = iChild1;
    }

    public String getsChild1() {
        return sChild1;
    }

    public void setsChild1(String sChild1) {
        this.sChild1 = sChild1;
    }
}
