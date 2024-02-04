package com.nhnacademy.edu.springframework.project.domain;

public class WaterBill {
    private final int no;
    private final String city;
    private final String sector;
    private final int step;
    private final long sectionStart;
    private final long sectionEnd;
    private final long unitPrice;

    private long billTotal;

    public WaterBill(int no, String city, String sector, int step, long sectionStart, long sectionEnd, long unitPrice) {
        this.no = no;
        this.city = city;
        this.sector = sector;
        this.step = step;
        this.sectionStart = sectionStart;
        this.sectionEnd = sectionEnd;
        this.unitPrice = unitPrice;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public long getSectionStart() {
        return sectionStart;
    }

    public long getSectionEnd() {
        return sectionEnd;
    }

    public void setBillTotal(long billTotal) {
        this.billTotal = billTotal;
    }

    @Override
    public String toString() {
        return "WaterBill{" +
                "city=" + city +
                ", sector='" + sector + '\'' +
                ", unitPrice=" + unitPrice + '\'' +
                ", billTotal=" + billTotal +
                '}' + '\n';
    }


}
