package com.teclan.puke;

import java.util.Random;

public abstract class AbstractPuke implements Puke {


    public abstract String[] getCard();

    public abstract int getCardNum();

    public abstract String[] qSort(String[] card, int start, int end);


    /**
     * 洗牌
     */
    public String[] shuffle() {
        String[] card = new String[54];
        System.arraycopy(getCard(), 0, card, 0, 54);

        for (int i = 0; i < card.length; i++) {
            int randomIndex = new Random().nextInt(getCardNum());
            swap(card, i, randomIndex);
        }

        return card;
    }


    /**
     * 将 card 中 index 位置 与 to 位置交换
     *
     * @param card
     * @param index
     * @param to
     */
    private  void swap(String[] card, int index, int to) {
        String temp = card[index];
        card[index] = card[to];
        card[to] = temp;
    }




    public  String getHumanInfo(String singelCard) {
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



}
