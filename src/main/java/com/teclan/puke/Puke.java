package com.teclan.puke;

import java.util.Random;

public class Puke {


    /**
     * 扑克牌
     */
    private static final String[] CARD = new String[]{
            "A-0", "2-0", "3-0", "4-0", "5-0", "6-0", "7-0", "8-0", "9-0", "10-0", "J-0", "Q-0", "K-0",// 方片
            "A-1", "2-1", "3-1", "4-1", "5-1", "6-1", "7-1", "8-1", "9-1", "10-1", "J-1", "Q-1", "K-1",// 梅花
            "A-2", "2-2", "3-2", "4-2", "5-2", "6-2", "7-2", "8-2", "9-2", "10-2", "J-2", "Q-2", "K-2",// 红桃
            "A-3", "2-3", "3-3", "4-3", "5-3", "6-3", "7-3", "8-3", "9-3", "10-3", "J-3", "Q-3", "K-3",// 黑桃
            "G-0",// 小王
            "G-1"// 大王
    };

    /**
     * 扑克牌数量
     */
    private static final int CARD_NUM = 54;

    /**
     * 洗牌
     */
    public static String[] shuffle() {
        String[] card = new String[54];
        System.arraycopy(CARD, 0, card, 0, 54);


        for (int i = 0; i < card.length; i++) {
            int randomIndex = new Random().nextInt(CARD_NUM);
            swap(card, i, randomIndex);
        }

        return card;
    }


    /**
     * 发牌
     *
     * @return
     */
    public static String[][] deal() {
        String[] card = shuffle();
        String[][] group = new String[4][14];
        System.arraycopy(card, 0, group[0], 0, 14);
        System.arraycopy(card, 14, group[1], 0, 14);
        System.arraycopy(card, 28, group[2], 0, 13);
        System.arraycopy(card, 41, group[3], 0, 13);
        return group;
    }


    public static String getHumanInfo(String singelCard) {

        if (singelCard == null) {
            return "";
        }

        String[] item = singelCard.split("-");
        String flower = "";

        if ("G".equals(item[0])) {

            if(item[1].equals("0")){
                return "小王";
            }else {
                return "大王";
            }


        } else {
            if (item[1].equals("0")) {
                flower = "方片 ";
            }

            if (item[1].equals("1")) {
                flower = "梅花 ";
            }

            if (item[1].equals("2")) {
                flower = "红心 ";
            }

            if (item[1].equals("3")) {
                flower = "黑桃 ";
            }
            return String.format("%s%s", flower, item[0]);
        }
    }


    private static void show(String[] card) {
        for (int i = 0; i < card.length; i++) {
            System.out.println(i + " = " + card[i]);
        }
    }


    /**
     * 将 card 中 index 位置 与 to 位置交换
     *
     * @param card
     * @param index
     * @param to
     */
    private static void swap(String[] card, int index, int to) {
        String temp = card[index];
        card[index] = card[to];
        card[to] = temp;
    }

}
