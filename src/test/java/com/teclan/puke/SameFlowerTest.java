package com.teclan.puke;

import com.teclan.puke.Douniu.Douniu;
import org.junit.Before;
import org.junit.Test;

public class SameFlowerTest {


    Douniu douniu;

    @Before
    public void setUp(){

        douniu = new Douniu();
    }


    @Test
    public void s1Test(){

        String[] card = new String[]{"A#3#47","3#3#3", "6#3#15",  "8#3#23", "J#3#35"};
        Helper.show(card);
        Helper.display(card);
    }
}
