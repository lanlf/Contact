package com.lan.contact;

import java.security.PrivateKey;

/**
 *  对联系人信息进行封装
 * Created by lan on 2016/7/16.
 */
public class ConInfo {
    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(String num) {
        this.num = num;
    }

    private String name;
    private String num;
    ConInfo(String name,String num){
        setName(name);
        setNum(num);
    }
}
