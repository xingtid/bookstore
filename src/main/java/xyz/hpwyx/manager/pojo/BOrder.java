package xyz.hpwyx.manager.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BOrder {
    private Integer oId;

    private Integer oStatus;

    private Integer oUserId;

    private Date oStartDate;

    private Date oEndDate;

    private Integer oOpertor;

    private String oOrderNo;

    private String oAlipayNo;

    private String oUserComment;

    private Integer oUserEvaluate;

    private BigDecimal oAmount;

    private String oPic;

    private String oMark;
    private List<Integer> id;
    private String userName;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getoStatus() {
        return oStatus;
    }
    public String getStatusStr() {
        switch (oStatus){
            case 1:
                return "待支付";
            case 2:
                return "已支付";
            case 3:
                return "待发货";
            case 4:
                return "已发货";
            case 5:
                return "已完成";
            default:
                return "";
        }
    }

    public void setoStatus(Integer oStatus) {
        this.oStatus = oStatus;
    }

    public Integer getoUserId() {
        return oUserId;
    }

    public void setoUserId(Integer oUserId) {
        this.oUserId = oUserId;
    }

    public Date getoStartDate() {
        return oStartDate;
    }

    public void setoStartDate(Date oStartDate) {
        this.oStartDate = oStartDate;
    }

    public Date getoEndDate() {
        return oEndDate;
    }

    public void setoEndDate(Date oEndDate) {
        this.oEndDate = oEndDate;
    }

    public Integer getoOpertor() {
        return oOpertor;
    }

    public void setoOpertor(Integer oOpertor) {
        this.oOpertor = oOpertor;
    }

    public String getoOrderNo() {
        return oOrderNo;
    }

    public void setoOrderNo(String oOrderNo) {
        this.oOrderNo = oOrderNo == null ? null : oOrderNo.trim();
    }

    public String getoAlipayNo() {
        return oAlipayNo;
    }

    public void setoAlipayNo(String oAlipayNo) {
        this.oAlipayNo = oAlipayNo == null ? null : oAlipayNo.trim();
    }

    public String getoUserComment() {
        return oUserComment;
    }

    public void setoUserComment(String oUserComment) {
        this.oUserComment = oUserComment == null ? null : oUserComment.trim();
    }

    public Integer getoUserEvaluate() {
        return oUserEvaluate;
    }

    public void setoUserEvaluate(Integer oUserEvaluate) {
        this.oUserEvaluate = oUserEvaluate;
    }

    public BigDecimal getoAmount() {
        return oAmount;
    }

    public void setoAmount(BigDecimal oAmount) {
        this.oAmount = oAmount;
    }

    public String getoPic() {
        return oPic;
    }

    public void setoPic(String oPic) {
        this.oPic = oPic == null ? null : oPic.trim();
    }

    public String getoMark() {
        return oMark;
    }

    public void setoMark(String oMark) {
        this.oMark = oMark == null ? null : oMark.trim();
    }

    public List<Integer> getId() {
        return id;
    }

    public void setId(List<Integer> id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}