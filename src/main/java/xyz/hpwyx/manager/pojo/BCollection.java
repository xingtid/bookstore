package xyz.hpwyx.manager.pojo;

import java.util.Date;

public class BCollection {
    private Integer cId;

    private Integer cUserId;

    private Integer cBookId;

    private Date cDate;

    private String cMark;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getcUserId() {
        return cUserId;
    }

    public void setcUserId(Integer cUserId) {
        this.cUserId = cUserId;
    }

    public Integer getcBookId() {
        return cBookId;
    }

    public void setcBookId(Integer cBookId) {
        this.cBookId = cBookId;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public String getcMark() {
        return cMark;
    }

    public void setcMark(String cMark) {
        this.cMark = cMark == null ? null : cMark.trim();
    }
}