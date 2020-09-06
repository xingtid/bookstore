package xyz.hpwyx.manager.pojo;

import java.util.Date;

public class BHistory {
    private Integer hId;

    private Integer hBookId;

    private Date hDate;

    private Integer hUserId;

    private Integer hIsAdd;

    private Integer hType;

    private String hMark;

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public Integer gethBookId() {
        return hBookId;
    }

    public void sethBookId(Integer hBookId) {
        this.hBookId = hBookId;
    }

    public Date gethDate() {
        return hDate;
    }

    public void sethDate(Date hDate) {
        this.hDate = hDate;
    }

    public Integer gethUserId() {
        return hUserId;
    }

    public void sethUserId(Integer hUserId) {
        this.hUserId = hUserId;
    }

    public Integer gethIsAdd() {
        return hIsAdd;
    }

    public void sethIsAdd(Integer hIsAdd) {
        this.hIsAdd = hIsAdd;
    }

    public Integer gethType() {
        return hType;
    }

    public void sethType(Integer hType) {
        this.hType = hType;
    }

    public String gethMark() {
        return hMark;
    }

    public void sethMark(String hMark) {
        this.hMark = hMark == null ? null : hMark.trim();
    }
}