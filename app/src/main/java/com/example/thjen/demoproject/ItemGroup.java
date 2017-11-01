package com.example.thjen.demoproject;

public class ItemGroup {

    private String sGroup1;
    private int iGroup;
    private String sGroup2;

    public ItemGroup(String sGroup1, int iGroup, String sGroup2) {
        this.sGroup1 = sGroup1;
        this.iGroup = iGroup;
        this.sGroup2 = sGroup2;
    }

    public String getsGroup1() {
        return sGroup1;
    }

    public void setsGroup1(String sGroup1) {
        this.sGroup1 = sGroup1;
    }

    public int getiGroup() {
        return iGroup;
    }

    public void setiGroup(int iGroup) {
        this.iGroup = iGroup;
    }

    public String getsGroup2() {
        return sGroup2;
    }

    public void setsGroup2(String sGroup2) {
        this.sGroup2 = sGroup2;
    }

}
