package com.teclan.puke;

import com.teclan.puke.Douniu.Douniu;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VaidOrderTest {

    Douniu douniu;

    @Before
    public void setUp(){

        douniu = new Douniu();
    }

    @Test
    public void order1Test(){

        String[] card = new String[]{"3#0#0","A#0#44", "2#1#48",  "4#3#4", "5#2#8"};
        Helper.show(card);
         Helper.display(card);
    }

    @Test
    public void order2Test(){

        String[] card = new String[]{ "3#0#0","2#1#48", "5#2#8", "4#3#4", "6#3#15"};
        Helper.show(card);
         Helper.display(card);
    }

    @Test
    public void order3Test(){

        String[] card = new String[]{ "8#3#23", "3#0#0", "4#3#4", "5#2#8","6#3#15"};
        Helper.show(card);
         Helper.display(card);
    }


    @Test
    public void order4Test(){

        String[] card = new String[]{ "A#0#44", "2#0#48", "3#0#0", "4#0#4", "5#0#8"};
        Helper.show(card);
         Helper.display(card);
    }


    @Test
    public void order5Test(){

        String[] card = new String[]{ "2#0#48", "3#0#0", "4#0#4", "5#0#8", "6#0#12"};
        Helper.show(card);
         Helper.display(card);
    }


    @Test
    public void order6Test(){

        String[] card = new String[]{ "9#2#26", "10#2#30", "J#2#34", "Q#2#38", "K#2#42"};
        Helper.show(card);
         Helper.display(card);
    }

    @Test
    public void order7Test() {

        String[] card = new String[]{  "10#2#30", "J#2#34", "Q#2#38", "K#2#42","A#2#46"};
        Helper.show(card);
         Helper.display(card);

    }

}
