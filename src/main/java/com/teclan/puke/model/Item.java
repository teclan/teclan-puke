package com.teclan.puke.model;

import java.util.Date;

public class Item {

    /**
     * 用户
     */
    private String userId;
    /**
     * 单次出牌集合
     */
    private String[] card;
    /**
     * 出牌时间
     */
    private Date pushAt;

    public Item() {
    }

    public Item(String userId, String[] card) {
        this.userId = userId;
        this.card = card;
        this.pushAt=new Date();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getCard() {
        return card;
    }

    public void setCard(String[] card) {
        this.card = card;
    }

    public Date getPushAt() {
        return pushAt;
    }

    public void setPushAt(Date pushAt) {
        this.pushAt = pushAt;
    }
}
