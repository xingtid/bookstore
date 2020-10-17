package xyz.hpwyx.manager.pojo;

public class BUser {
    private Integer uId;

    private String uUsername;

    private String uPassword;

    private String uName;

    private Integer uAge;

    private String uEducation;

    private String uEmail;

    private String uPhone;

    private String uAddress;

    private String uHobby;

    private String uIsAdmin;

    private String uDetail;

    private String uMark;
    private Integer carNum;
    private Integer collectionNum;
    private Integer orderNum;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername == null ? null : uUsername.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public Integer getuAge() {
        return uAge;
    }

    public void setuAge(Integer uAge) {
        this.uAge = uAge;
    }

    public String getuEducation() {
        return uEducation;
    }

    public void setuEducation(String uEducation) {
        this.uEducation = uEducation == null ? null : uEducation.trim();
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress == null ? null : uAddress.trim();
    }

    public String getuHobby() {
        return uHobby;
    }

    public void setuHobby(String uHobby) {
        this.uHobby = uHobby == null ? null : uHobby.trim();
    }

    public String getuIsAdmin() {
        return uIsAdmin;
    }

    public void setuIsAdmin(String uIsAdmin) {
        this.uIsAdmin = uIsAdmin == null ? null : uIsAdmin.trim();
    }

    public String getuDetail() {
        return uDetail;
    }

    public void setuDetail(String uDetail) {
        this.uDetail = uDetail == null ? null : uDetail.trim();
    }

    public String getuMark() {
        return uMark;
    }

    public void setuMark(String uMark) {
        this.uMark = uMark == null ? null : uMark.trim();
    }

    public Integer getCarNum() {
        return carNum;
    }

    public void setCarNum(Integer carNum) {
        this.carNum = carNum;
    }

    public Integer getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(Integer collectionNum) {
        this.collectionNum = collectionNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}