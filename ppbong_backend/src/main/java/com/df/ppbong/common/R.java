package com.df.ppbong.common;

import lombok.Data;

@Data
public class R {
    private String msg;
    /**
     * 状态码
     * 1xx
     * 2xx 成功
     * 3xx
     * 4xx 失败
     */
    private Integer code;
    private Object data;

    public R() {
    }

    public R( Integer code,String msg) {
        this.msg = msg;
        this.code = code;
    }

    public static R OK(){
        return new R(200,"" );
    }
    public static R OK(String msg){
        return new R(200,msg);
    }

    public static R ERROR(){
        return new R(400,"" );
    }

    public static R ERROR(String msg){
        return new R(400,msg );
    }

    public R setMsg(String msg){
        this.msg = msg;
        return this;
    }

    public R setCode(Integer code){
        this.code = code;
        return this;
    }

    public R setData(Object data){
        this.data = data;
        return this;
    }
}
