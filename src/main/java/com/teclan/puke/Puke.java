package com.teclan.puke;

import java.util.Random;

public class Puke {


    /**
     * 扑克牌
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

            if (item[1].equals("0")) {
                return "小王";
            } else {
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
