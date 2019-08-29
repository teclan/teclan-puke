package com.teclan.puke;

import com.teclan.puke.Douniu.Douniu;
import org.junit.Test;

public class DealTest {

    @Test
    public void deal() {

        Douniu douniu = new Douniu();

        String[][] group = douniu.deal();
        Helper.show(group);

        System.out.println("\n=============== 整理 =============== \n");

        douniu.qSort(group[0], 0, 13);
        douniu.qSort(group[1], 0, 13);
        douniu.qSort(group[2], 0, 13);
        douniu.qSort(group[3], 0, 13);
        Helper.show(group);

    }

}
