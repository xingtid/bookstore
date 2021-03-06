package xyz.hpwyx.manager.pojo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BBook {
    private Integer bId;

    private BigDecimal bPrice;

    private Integer bDiscount;

    private String bName;

    private String bPress;

    private Integer bTypeId;

    private String bAnthor;

    private Integer bIsNew;

    private Integer bBeSales;

    private Integer bIsSole;

    private String bIntroduce;

    private String bPic;

    private String bMark;

    private Integer pageNum;
    private List<String> picList;
    private String typeName;
    private Integer limit;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public BigDecimal getbPrice() {
        return bPrice;
    }

    public void setbPrice(BigDecimal bPrice) {
        this.bPrice = bPrice;
    }

    public Integer getbDiscount() {
        return bDiscount;
    }

    public void setbDiscount(Integer bDiscount) {
        this.bDiscount = bDiscount;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getbPress() {
        return bPress;
    }

    public void setbPress(String bPress) {
        this.bPress = bPress == null ? null : bPress.trim();
    }

    public Integer getbTypeId() {
        return bTypeId;
    }

    public void setbTypeId(Integer bTypeId) {
        this.bTypeId = bTypeId;
    }

    public String getbAnthor() {
        return bAnthor;
    }

    public void setbAnthor(String bAnthor) {
        this.bAnthor = bAnthor == null ? null : bAnthor.trim();
    }

    public Integer getbIsNew() {
        return bIsNew;
    }

    public void setbIsNew(Integer bIsNew) {
        this.bIsNew = bIsNew;
    }

    public Integer getbBeSales() {
        return bBeSales;
    }

    public void setbBeSales(Integer bBeSales) {
        this.bBeSales = bBeSales;
    }

    public Integer getbIsSole() {
        return bIsSole;
    }

    public void setbIsSole(Integer bIsSole) {
        this.bIsSole = bIsSole;
    }

    public String getbIntroduce() {
        return bIntroduce;
    }

    public void setbIntroduce(String bIntroduce) {
        this.bIntroduce = bIntroduce == null ? null : bIntroduce.trim();
    }

    public String getbPic() {
        if (this.bPic == null){
            return null;
        }
        String[] split = this.bPic.split ("\\|");
        List<String> picList = Arrays.asList (split);
        if (picList.size ()>0){
            return picList.get (0);
        }
        return null;
    }

    public void setbPic(String bPic) {
        this.bPic = bPic == null ? null : bPic.trim();
    }

    public String getbMark() {
        return bMark;
    }

    public void setbMark(String bMark) {
        this.bMark = bMark == null ? null : bMark.trim();
    }

    public Integer getPageNum() {
        if (this.pageNum == null){
            return 0;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}