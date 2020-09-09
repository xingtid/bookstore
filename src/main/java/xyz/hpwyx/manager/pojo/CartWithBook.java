package xyz.hpwyx.manager.pojo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CartWithBook {
    private Integer id;
    private BigDecimal singalPrice;

    private Integer bDiscount;

    private String name;

    private String bPress;

    private Integer bTypeId;

    private String bAnthor;

    private Integer bIsNew;

    private Integer bBeSales;

    private Integer bIsSole;

    private String bIntroduce;

    private String img;

    private String goodTip;
    private Integer cCount;

    private Integer cBookId;
    private BigDecimal cPrice;
    private BigDecimal cAll;
    private BigDecimal cTotal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getbDiscount() {
        return bDiscount;
    }

    public void setbDiscount(Integer bDiscount) {
        this.bDiscount = bDiscount;
    }

    public String getbPress() {
        return bPress;
    }

    public void setbPress(String bPress) {
        this.bPress = bPress;
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
        this.bAnthor = bAnthor;
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
        this.bIntroduce = bIntroduce;
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

    public BigDecimal getSingalPrice() {
        return singalPrice;
    }

    public void setSingalPrice(BigDecimal singalPrice) {
        this.singalPrice = singalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        if (this.img == null){
            return null;
        }
        String[] split = this.img.split ("\\|");
        List<String> picList = Arrays.asList (split);
        if (picList.size ()>0){
            return picList.get (0);
        }
        return null;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGoodTip() {
        return goodTip;
    }

    public void setGoodTip(String goodTip) {
        this.goodTip = goodTip;
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

    public BigDecimal getcTotal() {
        return cTotal;
    }

    public void setcTotal(BigDecimal cTotal) {
        this.cTotal = cTotal;
    }
}
