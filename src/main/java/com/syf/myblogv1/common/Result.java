package com.syf.myblogv1.common;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Auther: shenyafeng
 * @Date: 2022/1/15 10:45
 * @Description:controller层结果封装
 */
@Data
public class Result implements Serializable {
    private String code;
    private String msg;
    private Object data;



    public static Result succ(Object data) {
        Result m = new Result();
        m.setCode("0");
        m.setData(data);
        m.setMsg("操作成功");
        return m;
    }
    public static Result succ(String mess, Object data) {
        Result m = new Result();
        m.setCode("0");
        m.setData(data);
        m.setMsg(mess);
        return m;
    }
    public static Result fail(String mess) {
        Result m = new Result();
        m.setCode("-1");
        m.setData(null);
        m.setMsg(mess);
        return m;
    }
    public static Result fail(String mess, Object data) {
        Result m = new Result();
        m.setCode("-1");
        m.setData(data);
        m.setMsg(mess);
        return m;
    }

    public static void main(String[] args) {
        Result fail = Result.fail("1");
        System.out.println(JSON.toJSONString(fail));

    }






}
