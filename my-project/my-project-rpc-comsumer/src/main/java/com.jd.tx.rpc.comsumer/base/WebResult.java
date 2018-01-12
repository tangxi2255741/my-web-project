package com.jd.tx.domain.base;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by cdtangxi on 2017/10/26.
 */
public class WebResult {
    private String code;// 编码
    private String result;// 结果
    private Object data;// 数据

    public WebResult(String code, String result) {
        this.code = code;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @SuppressWarnings("unchecked")
    public <E> E getData() {
        return (E) data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static WebResult create(String code, String result) {
        return new WebResult(code, result);
    }

    public static WebResult success() {
        return success("操作成功!");
    }

    public static WebResult success(String msg) {
        return create("success", msg);
    }

    public static WebResult failure() {
        return failure("操作失败!");
    }

    public static WebResult failure(String msg) {
        return create("failure", msg);
    }

    public static WebResult failure(Exception ex) {
        return failure("系统异常:"+ex.getMessage(),ex);
    }

    public static WebResult failure(String message, Exception ex) {
        if(ex == null) {
            return failure();
        }
        WebResult msg = failure(message);
        try {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            msg.setData(sw.toString());
        } catch (Exception e) {
        }
        return msg;
    }
}
