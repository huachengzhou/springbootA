package com.blue.common.enums;

/**
 * @Author zch
 * @Description
 * @createDate 2018/11/3
 **/
public enum Views {
    WEB_INF("WEB-INF/","模型视图常量"),
    CORE_VIEW("coreView/","模型视图常量");
    private String var;
    private String temp;

    private int size;

    Views(String var) {
        this.var = var;
    }

    Views(int size) {
        this.size = size;
    }

    Views(String var,String temp){
        this.var = var;
        this.temp = temp;
    }

    public int getSize() {
        return size;
    }

    public String getVar() {
        return var;
    }
}
