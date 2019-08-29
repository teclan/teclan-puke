package com.teclan.puke;

import com.teclan.puke.Douniu.Douniu;
import org.junit.Test;

public class DealTest {

    @Test
    public void deal() {

        Douniu douniu = new Douniu();

        String[][] group = douniu.deal();
        show(group, douniu);

        System.out.println("\n=============== 整理 =============== \n");

        douniu.qSort(group[0], 0, 13);
        douniu.qSort(group[1], 0, 13);
        douniu.qSort(group[2], 0, 13);
        douniu.qSort(group[3], 0, 13);
        show(group, douniu);

    }

    private void show(String[][] group, Puke puke) {
        for (int i = 0; i < 14; i++) {
            System.out.println(String.format("%s\t%s\t%s\t%s", puke.getHumanInfo(group[0][i]), puke.getHumanInfo(group[1][i]), puke.getHumanInfo(group[2][i]), puke.getHumanInfo(group[3][i])));
        }
    }
}
