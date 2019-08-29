package com.teclan.puke.Douniu;

import com.teclan.puke.AbstractPuke;

public class Douniu extends AbstractPuke {


    /**
     * 扑克牌
     * <p>
     * 面值-花色-位置
     * <p>
     * 花色：0/1/2/3 方片/梅花/红心/黑桃
     * 位置: 0~53,数字越大，对应的牌面越大
     */
    private static final String[] CARD = new String[]{
            "A-0-44", "2-0-48", "3-0-0", "4-0-4", "5-0-8", "6-0-12", "7-0-16", "8-0-20", "9-0-24", "10-0-28", "J-0-32", "Q-0-36", "K-0-40",// 方片
            "A-1-45", "2-1-49", "3-1-1", "4-1-5", "5-1-9", "6-1-13", "7-1-17", "8-1-21", "9-1-25", "10-1-29", "J-1-33", "Q-1-37", "K-1-41",// 梅花
            "A-2-46", "2-2-50", "3-2-2", "4-2-6", "5-2-10", "6-2-14", "7-2-18", "8-2-22", "9-2-26", "10-2-30", "J-2-34", "Q-2-38", "K-2-42",// 红桃
            "A-3-47", "2-3-51", "3-3-3", "4-3-7", "5-3-11", "6-3-15", "7-3-19", "8-3-23", "9-3-27", "10-3-31", "J-3-35", "Q-3-39", "K-3-43",// 黑桃
            "G-0-52",// 小王
            "G-1-53"// 大王
    };

    /**
     * 扑克牌数量
     */
    private static final int CARD_NUM = 54;


    public String[] getCard() {
        return CARD;
    }


    public int getCardNum() {
        return CARD_NUM;
    }

    /**
     * 发牌
     *
     * @return
     */
    public String[][] deal() {
        String[] card = shuffle();
        String[][] group = new String[4][14];
        System.arraycopy(card, 0, group[0], 0, 14);
        System.arraycopy(card, 14, group[1], 0, 14);
        System.arraycopy(card, 28, group[2], 0, 13);
        System.arraycopy(card, 41, group[3], 0, 13);
        return group;
    }


    /**
     * 排序
     *
     * @param card
     * @return
     */
    public String[] qSort(String[] card, int start, int end) {

        while (card[end] == null) {
            end--;
        }

        Integer pivot = Integer.valueOf(card[start].split("-")[2]);
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (Integer.valueOf(card[j].split("-")[2]) > pivot)) {
                j--;
            }
            while ((i < j) && (Integer.valueOf(card[i].split("-")[2]) < pivot)) {
                i++;
            }
            if ((card[i].split("-")[2] == card[j].split("-")[2]) && (i < j)) {
                i++;
            } else {
                String temp = card[i];
                card[i] = card[j];
                card[j] = temp;
            }
        }
        if (i - 1 > start) {
            card = qSort(card, start, i - 1);
        }
        if (j + 1 < end) {
            card = qSort(card, j + 1, end);
        }
        return card;
    }


}
