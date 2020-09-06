package xyz.hpwyx.manager.pojo;

import java.math.BigDecimal;

public class BOrderDetail {
    private Integer odId;

    private Integer odOrderId;

    private Integer odBookId;

    private Integer odCount;

    private BigDecimal odPrice;

    private String odMark;

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public Integer getOdOrderId() {
        return odOrderId;
    }

    public void setOdOrderId(Integer odOrderId) {
        this.odOrderId = odOrderId;
    }

    public Integer getOdBookId() {
        return odBookId;
    }

    public void setOdBookId(Integer odBookId) {
        this.odBookId = odBookId;
    }

    public Integer getOdCount() {
        return odCount;
    }

    public void setOdCount(Integer odCount) {
        this.odCount = odCount;
    }

    public BigDecimal getOdPrice() {
        return odPrice;
    }

    public void setOdPrice(BigDecimal odPrice) {
        this.odPrice = odPrice;
    }

    public String getOdMark() {
        return odMark;
    }

    public void setOdMark(String odMark) {
        this.odMark = odMark == null ? null : odMark.trim();
    }
}