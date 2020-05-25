package cn.zyj.zsblog.entity.Bo;

import java.util.List;

public class ResultMessage<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultMessage(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultMessage(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> ResultMessage<T> resultMessage_success(T data){
        return new ResultMessage<T>(1,"成功",data);
    }

    public static <T> ResultMessage<T> resultMessage_failed(){
        return new ResultMessage<T>(2,"失败");
    }


}
