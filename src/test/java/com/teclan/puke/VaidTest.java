package com.teclan.puke;

import com.teclan.puke.Douniu.Douniu;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VaidTest {

    Douniu douniu;

    @Before
    public void setUp(){

        douniu = new Douniu();
    }

    @Test
    public void order1Test(){

        String[] card = new String[]{"3#0#0","A#0#44", "2#1#48",  "4#3#4", "5#2#8"};
        Helper.show(card);
        display(card);
    }

    @Test
    public void order2Test(){

        String[] card = new String[]{ "3#0#0","2#1#48", "5#2#8", "4#3#4", "6#3#15"};
        Helper.show(card);
        display(card);
    }

    @Test
    public void order3Test(){

        String[] card = new String[]{ "8#3#23", "3#0#0", "4#3#4", "5#2#8","6#3#15"};
        Helper.show(card);
        display(card);
    }

    private void display(String[] card){

        System.out.println("是否顺子:"+douniu.isCommonOrder(card));
        System.out.println("是否担子:"+douniu.isTake(card));
        System.out.println("是否金刚:"+douniu.isKingKong(card));
        System.out.println("是否同花:"+douniu.isSameFlower(card));
        System.out.println("是否对子:"+douniu.isCouple(card));
    }
}
