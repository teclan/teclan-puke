package com.teclan.puke;

public interface Puke {

    /**
     * 获取扑克牌数据
     *
     * @return
     */
    public String[] getCard();

    /**
     * 手牌排序
     *
     * @param card
     * @param start
     * @param end
     * @return
     */
    public String[] qSort(String[] card, int start, int end);

    /**
     * 洗牌
     *
     * @return
     */
    public String[] shuffle();


    /**
     * 发牌
     *
     * @return
     */
    public String[][] deal();


    /**
     * 牌面解释
     * @param singelCard
     * @return
     */
    public  String getHumanInfo(String singelCard);


    /**
     * 出牌验证
     * @param last 上次出牌
     * @param next  本次即将出牌
     * @return
     */
    public boolean vaid(String deskId,String[] next);
}
