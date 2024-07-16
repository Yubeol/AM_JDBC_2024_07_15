package org.koreait.dto;

import java.util.Map;

public class Member {
    private int id;
    private String regDate;
    private String updateDate;
    private String loginId;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", regDate='" + regDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", loginId='" + loginId + '\'' +
                ", loginPw='" + loginPw + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private String loginPw;

    public Member(int id, String regDate, String updateDate, String loginId, String loginPw, String name) {
        this.id = id;
        this.regDate = regDate;
        this.updateDate = updateDate;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPw() {
        return loginPw;
    }

    public void setLoginPw(String loginPw) {
        this.loginPw = loginPw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Member(Map<String, Object> articleMap) {
        this.id = (int) articleMap.get("id");
        this.regDate = (String) articleMap.get("regDate");
        this.updateDate = (String) articleMap.get("updateDate");
        this.loginId = (String) articleMap.get("loginId");
        this.loginPw = (String) articleMap.get("loginPw");
        this.name = (String) articleMap.get("name");
    }

}