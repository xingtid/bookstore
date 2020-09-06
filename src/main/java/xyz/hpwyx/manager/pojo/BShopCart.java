package xyz.hpwyx.manager.pojo;

import java.math.BigDecimal;

public class BShopCart {
    private Integer cId;

    private Integer cUserId;

    private Integer cCount;

    private Integer cBookId;

    private BigDecimal cPrice;

    private BigDecimal cAll;

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

    public Integer getcCount() {
        return cCount;
    }

    public void setcCount(Integer cCount) {
        this.cCount = cCount;
    }

    public Integer getcBookId() {
        return cBookId;
    }

    public void setcBookId(Integer cBookId) {
        this.cBookId = cBookId;
    }

    public BigDecimal getcPrice() {
        return cPrice;
    }

    public void setcPrice(BigDecimal cPrice) {
        this.cPrice = cPrice;
    }

    public BigDecimal getcAll() {
        return cAll;
    }

    public void setcAll(BigDecimal cAll) {
        this.cAll = cAll;
    }

    public String getcMark() {
        return cMark;
    }

    public void setcMark(String cMark) {
        this.cMark = cMark == null ? null : cMark.trim();
    }
}