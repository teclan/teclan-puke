package com.teclan.puke;

import org.junit.Test;

public class DealTest {

    @Test
    public void deal(){

      String[][] group =   Puke.deal();
        show(group);
    }

    private void show(String[][] group){
        for(int i=0;i<14;i++){
         System.out.println(String.format("%s\t%s\t%s\t%s",Puke.getHumanInfo(group[0][i]),Puke.getHumanInfo(group[1][i]),Puke.getHumanInfo(group[2][i]),Puke.getHumanInfo(group[3][i])));
        }
    }
}
