package xyz.hpwyx.manager.common;

/**
 * 结果集 封装类  用于判断ajax请求结果是否成功，并返回错误或者成功消息
 */
public class Result {
    private Integer resultCode;
    private String msg;
    private Object data;

    public static Result success() {
        Result result = new Result ();
        result.setMsg ("请求成功");
        result.setResultCode (200);
        return result;
    }
    public static Result fail(String msg) {
        Result result = new Result ();
        result.setMsg (msg);
        result.setResultCode (500);
        return result;
    }
    public static Result success(Object data) {
        Result result = new Result ();
        result.setData (data);
        result.setMsg ("请求成功");
        result.setResultCode (200);
        return result;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
