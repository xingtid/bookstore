package xyz.hpwyx.manager.pojo;

public class BBookType {
    private Integer tId;

    private String tName;

    private String tMark;

    private String tUrl;
    private Integer tCount;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettMark() {
        return tMark;
    }

    public void settMark(String tMark) {
        this.tMark = tMark == null ? null : tMark.trim();
    }

    public String gettUrl() {
        return tUrl;
    }

    public void settUrl(String tUrl) {
        this.tUrl = tUrl == null ? null : tUrl.trim();
    }

    public Integer gettCount() {
        return tCount;
    }

    public void settCount(Integer tCount) {
        this.tCount = tCount;
    }
}