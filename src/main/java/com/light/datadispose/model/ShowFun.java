package com.light.datadispose.model;


import java.util.List;

/**
 * 该类代表了可显示的功能组或单个功能
 */
public class ShowFun {
    private String name;//功能名称
    private String description;//功能描述
    private String url;//功能请求地址
    private List<ShowFun> showFuns;//子功能列表

    @Override
    public String toString() {
        return "ShowFun{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", showFuns=" + showFuns +
                '}';
    }

    public ShowFun(String name, String description, String url, List<ShowFun> showFuns) {
        this.name = name;
        this.description = description;
        this.showFuns = showFuns;
        this.url=url;
    }
    public ShowFun(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ShowFun> getShowFuns() {
        return showFuns;
    }

    public void setShowFuns(List<ShowFun> showFuns) {
        this.showFuns = showFuns;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
