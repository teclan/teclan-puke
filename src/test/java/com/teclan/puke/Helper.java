package com.teclan.puke;

import com.teclan.puke.Douniu.Douniu;

public class Helper {

    public static  void show(String[][] group) {

        Puke puke = new Douniu();

        for (int i = 0; i < 14; i++) {
            System.out.println(String.format("%s\t%s\t%s\t%s", puke.getHumanInfo(group[0][i]), puke.getHumanInfo(group[1][i]), puke.getHumanInfo(group[2][i]), puke.getHumanInfo(group[3][i])));
        }
    }

    public static  void show(String[] card) {

        Puke puke = new Douniu();

        for (int i = 0; i < card.length; i++) {
            System.out.println(String.format("%s", puke.getHumanInfo(card[i])));
        }
    }

    public static void display(String[] card){

        Douniu douniu = new Douniu();
        System.out.println("是否顺子:"+douniu.isCommonOrder(card));
        System.out.println("是否担子:"+douniu.isTake(card));
        System.out.println("是否金刚:"+douniu.isKingKong(card));
        System.out.println("是否同花:"+douniu.isSameFlower(card));
        System.out.println("是否对子:"+douniu.isCouple(card));
    }
}
