package com.ssm.test.domain;

import java.math.BigDecimal;

public class Section {
    private Integer id;

    private Integer bookid;

    private Integer sectionnum;

    private String sectiontitle;

    private BigDecimal sectionprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getSectionnum() {
        return sectionnum;
    }

    public void setSectionnum(Integer sectionnum) {
        this.sectionnum = sectionnum;
    }

    public String getSectiontitle() {
        return sectiontitle;
    }

    public void setSectiontitle(String sectiontitle) {
        this.sectiontitle = sectiontitle == null ? null : sectiontitle.trim();
    }

    public BigDecimal getSectionprice() {
        return sectionprice;
    }

    public void setSectionprice(BigDecimal sectionprice) {
        this.sectionprice = sectionprice;
    }
}