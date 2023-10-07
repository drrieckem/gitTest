package com.example.commom;


/**
 * Controller 统一返回的包装类
 */
public class Result {

    private static final String SUCCESS_CODE = "200";
    private static final String ERROR_CODE = "500";

    private String code;  // 返回状态码
    private String msg;   //返回状态消息
    private Object data;  //返回数据
//    data 字段是私有的，这意味着它只能在类的内部访问，不能直接从类的外部访问。为了从外部访问和设置 data 字段的值，需要提供公共的 getter 和 setter 方法。
//    Getter 方法（如 getData()）用于获取字段的值，允许外部代码读取 data 的值。
//    Setter 方法（如 setData(Object data)）用于设置字段的值，允许外部代码修改 data 的值。

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public static Result success(Object data) {
        return new Result(SUCCESS_CODE, "",data);
    }

    public static Result success() {
        return new Result(SUCCESS_CODE,"",null);
    }
    public static Result error(String msg) {
        return new Result(ERROR_CODE, msg, null);
    }

}
