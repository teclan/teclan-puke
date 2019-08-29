package com.teclan.puke;

import com.teclan.puke.Douniu.Douniu;
import org.junit.Test;

public class DealTest {

    @Test
    public void deal(){

      String[][] group =   Douniu.deal();
        show(group);

        System.out.println("\n=============== 整理 =============== \n");

        Douniu.qSort(group[0],0,13);
        Douniu.qSort(group[1],0,13);
        Douniu.qSort(group[2],0,13);
        Douniu.qSort(group[3],0,13);
        show(group);

    }

    private void show(String[][] group){
        for(int i=0;i<14;i++){
         System.out.println(String.format("%s\t%s\t%s\t%s", AbstractPuke.getHumanInfo(group[0][i]), AbstractPuke.getHumanInfo(group[1][i]), AbstractPuke.getHumanInfo(group[2][i]), AbstractPuke.getHumanInfo(group[3][i])));
        }
    }
}
