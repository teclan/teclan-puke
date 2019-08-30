package com.teclan.puke.Douniu;

import com.teclan.puke.AbstractPuke;
import com.teclan.puke.desk.DeskCache;
import com.teclan.puke.model.Item;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Douniu extends AbstractPuke {


    /**
     * 扑克牌
     * <p>
     * 面值#花色#位置
     * <p>
     * 花色：0/1/2/3 方片/梅花/红心/黑桃
     * 位置: 0~53,数字越大，对应的牌面越大
     */
    public static final String[] CARD = new String[]{
            "A#0#44", "2#0#48", "3#0#0", "4#0#4", "5#0#8", "6#0#12", "7#0#16", "8#0#20", "9#0#24", "10#0#28", "J#0#32", "Q#0#36", "K#0#40",// 方片
            "A#1#45", "2#1#49", "3#1#1", "4#1#5", "5#1#9", "6#1#13", "7#1#17", "8#1#21", "9#1#25", "10#1#29", "J#1#33", "Q#1#37", "K#1#41",// 梅花
            "A#2#46", "2#2#50", "3#2#2", "4#2#6", "5#2#10", "6#2#14", "7#2#18", "8#2#22", "9#2#26", "10#2#30", "J#2#34", "Q#2#38", "K#2#42",// 红桃
            "A#3#47", "2#3#51", "3#3#3", "4#3#7", "5#3#11", "6#3#15", "7#3#19", "8#3#23", "9#3#27", "10#3#31", "J#3#35", "Q#3#39", "K#3#43",// 黑桃
            "G#0#52",// 小王
            "G#1#53"// 大王
    };

    public static Map<String, String> CHANGE1 = new HashMap<String, String>();
    public static Map<String, String> CHANGE2 = new HashMap<String, String>();

    static {

        CHANGE1.put("J#0#32", "11#0#32");
        CHANGE1.put("J#1#33", "11#1#33");
        CHANGE1.put("J#2#34", "11#2#34");
        CHANGE1.put("J#3#35", "11#3#35");

        CHANGE1.put("Q#0#36", "12#0#36");
        CHANGE1.put("Q#1#37", "12#1#37");
        CHANGE1.put("Q#2#38", "12#2#38");
        CHANGE1.put("Q#3#39", "12#3#39");

        CHANGE1.put("K#0#40", "13#0#40");
        CHANGE1.put("K#1#41", "13#1#41");
        CHANGE1.put("K#2#42", "13#2#42");
        CHANGE1.put("K#3#43", "13#3#43");

        CHANGE1.put("A#0#44", "14#0#44");
        CHANGE1.put("A#1#45", "14#1#45");
        CHANGE1.put("A#2#46", "14#2#46");
        CHANGE1.put("A#3#47", "14#3#47");


        CHANGE2.put("J#0#32", "11#0#32");
        CHANGE2.put("J#1#33", "11#1#33");
        CHANGE2.put("J#2#34", "11#2#34");
        CHANGE2.put("J#3#35", "11#3#35");

        CHANGE2.put("Q#0#36", "12#0#36");
        CHANGE2.put("Q#1#37", "12#1#37");
        CHANGE2.put("Q#2#38", "12#2#38");
        CHANGE2.put("Q#3#39", "12#3#39");

        CHANGE2.put("K#0#40", "13#0#40");
        CHANGE2.put("K#1#41", "13#1#41");
        CHANGE2.put("K#2#42", "13#2#42");
        CHANGE2.put("K#3#43", "13#3#43");

        CHANGE2.put("A#0#44", "1#0#44");
        CHANGE2.put("A#1#45", "1#1#45");
        CHANGE2.put("A#2#46", "1#2#46");
        CHANGE2.put("A#3#47", "1#3#47");

    }

    /**
     * 扑克牌数量
     */
    public static final int CARD_NUM = 54;


    public String[] getCard() {
        return CARD;
    }


    public int getCardNum() {
        return CARD_NUM;
    }

    /**
     * 发牌
     *
     * @return
     */
    public String[][] deal() {
        String[] card = shuffle();
        String[][] group = new String[4][14];
        System.arraycopy(card, 0, group[0], 0, 14);
        System.arraycopy(card, 14, group[1], 0, 14);
        System.arraycopy(card, 28, group[2], 0, 13);
        System.arraycopy(card, 41, group[3], 0, 13);
        return group;
    }


    /**
     * 排序
     *
     * @param card
     * @return
     */
    public String[] qSort(String[] card, int start, int end) {

        while (card[end] == null) {
            end--;
        }

        Integer pivot = Integer.valueOf(card[start].split("#")[2]);
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (Integer.valueOf(card[j].split("#")[2]) > pivot)) {
                j--;
            }
            while ((i < j) && (Integer.valueOf(card[i].split("#")[2]) < pivot)) {
                i++;
            }
            if ((card[i].split("#")[2] == card[j].split("#")[2]) && (i < j)) {
                i++;
            } else {
                String temp = card[i];
                card[i] = card[j];
                card[j] = temp;
            }
        }
        if (i - 1 > start) {
            card = qSort(card, start, i - 1);
        }
        if (j + 1 < end) {
            card = qSort(card, j + 1, end);
        }
        return card;
    }


    public boolean vaid(String deskId, String[] next) {
        Item item = DeskCache.peek(deskId);
        return vaid(item, next);
    }


    public boolean vaid(String[] last, String[] next) {

        int length = next.length;

        // 出单张
        if (length == 1) {
            return last == null ? true : Integer.valueOf(next[0].split("#")[2]) > Integer.valueOf(next[0].split("#")[2]);
        }

        // 出对子
        if (length == 2) {

            boolean isCouple = isCouple(next);

            if (!isCouple) {
                // 不是对子，出牌不合规则
                return false;
            }

            if (last == null) {// 自己讲话，只要是对子就行
                return true;
            } else { // 接上家，则对子必须比上家大。如果任一牌面比上家大，则肯定大；如果牌面小，肯定大不了；如果牌面一致，必须有黑桃
                int lastValue = Integer.valueOf(last[0].split("#")[0]); // 上家牌面
                int nextValue = Integer.valueOf(next[0].split("#")[0]); // 上家牌面

                if (nextValue > lastValue) { // 牌面比上家大，符合规则
                    return true;
                }

                if (nextValue == lastValue) { // 牌面一样大，比较花色
                    int lastMaxFlower = Integer.valueOf(last[0].split("#")[1]) > Integer.valueOf(last[1].split("#")[1]) ? Integer.valueOf(last[0].split("#")[1]) : Integer.valueOf(last[1].split("#")[1]);// 上家最大花色
                    int nextMaxFlower = Integer.valueOf(next[0].split("#")[1]) > Integer.valueOf(next[1].split("#")[1]) ? Integer.valueOf(next[0].split("#")[1]) : Integer.valueOf(next[1].split("#")[1]);// 当前最大花色
                    return nextMaxFlower > lastMaxFlower;
                }
            }
        }

        // 出五张  3带2，4带1,顺子，花色相同
        if (length == 5) {

            if (last == null) {// 自己讲话
                // 如果是 3带2 或 4带1
                if (isTake(next)) {
                    return true;
                }

                // 如果是顺子（或金刚），合理
                if (isCommonOrder(next)) {
                    return true;
                }

                // 如果是同花，合理
                if (isSameFlower(next)) {
                    return true;
                }

            } else { // 如果都是顺子，比较最后一张牌面大小

                //================== 上家是 3带2 或 4带1 ============================
                boolean lt = isTake(last);
                if (lt) {
                    // 本次比上家大（比较三个或4个那一组），合理
                    if (isTake(last, next)) {
                        return true;
                    }
                }

                //================== 上家是金刚 ============================
                // 则本次也必须是金刚，而且最后一张牌要比上家大
                if (isKingKong(last) && isKingKong(next) && getMaxValue(next) > getMaxValue(last)) {
                    return true;
                }

                //================== 上家是普通顺子 ============================
                boolean lco = isCommonOrder(last);// 上家是普通顺子
                if (lco) {
                    // 上家普通顺子，本次 3带2 或 4带1，合理
                    if (isTake(next)) {
                        return true;
                    }
                    boolean nco = isCommonOrder(next);// 本次是普通顺子
                    // 上家普通顺子，本次也是顺子，但是最后一张牌比上家大，合理
                    if (nco && getMaxValue(next) > getMaxValue(last)) { // 上家和本次都是普通顺子，比较最后一张牌
                        return true;
                    }

                    if ((nco && isKingKong(next))) {// 上家是普通顺子，本次是金刚
                        return true;
                    }
                    // 上家是顺子，本次同花色
                    if (isSameFlower(next)) {
                        return true;
                    }
                }

                //================== 上家是同花 ============================
                boolean lsf = isSameFlower(last);
                if (lsf) {
                    // 本次 3带2，4带1，合理
                    if (isTake(next)) {
                        return true;
                    }

                    // 本次 金刚 合理
                    if (isKingKong(next)) {
                        return true;
                    }

                    // 本次也是同花，但有一张牌比上家大，合理
                    if (isSameFlower(next) && getMaxValue(next) > getMaxValue(last)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean isKingKong(String[] array) {

        String[] temp  =afterChange(array,CHANGE1);
        maopao(temp);

        boolean flag = true;

        for (int i = 1; i < array.length; i++) {
            if (Integer.valueOf(temp[i].split("#")[0]) != Integer.valueOf(temp[i - 1].split("#")[0]) + 1) {
                flag= false;
                break;
            }

            if (Integer.valueOf(temp[i].split("#")[1]) != Integer.valueOf(temp[i - 1].split("#")[1])) {
                flag= false;
                break;
            }
        }

        if(!flag){

            flag=true;
            temp  =afterChange(array,CHANGE2);

            for (int i = 1; i < array.length; i++) {
                if (Integer.valueOf(temp[i].split("#")[0]) != Integer.valueOf(temp[i - 1].split("#")[0]) + 1) {
                    flag= false;
                    break;
                }

                if (Integer.valueOf(temp[i].split("#")[1]) != Integer.valueOf(temp[i - 1].split("#")[1])) {
                    flag= false;
                    break;
                }
            }
        }

        return flag;
    }


    /**
     * 是否同花色
     *
     * @param array
     * @return
     */
    public boolean isSameFlower(String[] array) {
        for (int i = 1; i < array.length; i++) {
            if (Integer.valueOf(array[i].split("#")[1]) != Integer.valueOf(array[i - 1].split("#")[1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否 3带2 或者 4带1
     *
     * @param last
     * @param next
     * @return
     */
    public boolean isTake(String[] last, String[] next) {

        Map<String, Integer> lastMap = new HashMap<String, Integer>();
        Map<String, Integer> nextMap = new HashMap<String, Integer>();

        for (int i = 0; i < last.length; i++) {
            String card = last[i].split("#")[0];
            lastMap.put(card, lastMap.get(card) == null ? 1 : Integer.valueOf(lastMap.get(card) + 1));
        }


        for (int i = 0; i < last.length; i++) {
            String card = next[i].split("#")[0];
            nextMap.put(card, nextMap.get(card) == null ? 1 : Integer.valueOf(nextMap.get(card) + 1));
        }


        for (String k1 : nextMap.keySet()) {

            int c1 = nextMap.get(k1);
            if (c1 < 3) {
                continue;
            }

            for (String k2 : lastMap.keySet()) {
                int c2 = nextMap.get(k1);
                if (c1 < 3) {
                    continue;
                }

                if (c1 > c2) { // 上家 3 带 1，本次出 4 带 1，合理
                    return true;
                }

                if (c1 == c2) {
                    return k1.compareTo(k2) > 0;
                }
            }
        }

        return false;
    }


    public boolean isTake(String[] array) {

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < array.length; i++) {
            String card = array[i].split("#")[0];
            map.put(card, map.get(card) == null ? 1 : Integer.valueOf(map.get(card) + 1));
        }

        if (map.keySet().size() != 2) {
            return false;
        }

        String s = "";

        for (String k : map.keySet()) {
            s += map.get(k) + "#";
        }

        return (s.contains("3") && s.contains("2")) || (s.contains("4") && s.contains("1"));
    }

    public String getFromChange(Map<String, String> map, String v) {

        if (map.containsKey(v)) {
            return map.get(v);
        }

        return v;
    }

    public boolean isCouple(String[] array) {
        return array.length == 2 && array[0].split("#")[0].equals(array[1].split("#")[0]);
    }


    private String[] afterChange(String[] array,Map<String,String> map){
        String[] temp = new String[array.length];

        System.arraycopy(array, 0, temp, 0, array.length);

        for (int i = 0; i < temp.length; i++) {
            temp[i] = getFromChange(map, temp[i]);
        }

        return temp;
    }

    /**
     * 判断是否是普通顺子
     *
     * @param array
     * @return
     */
    public boolean isCommonOrder(String[] array) {

        String[] temp =afterChange(array,CHANGE1);
        maopao(temp);

        boolean flag = true;

        for (int i = 1; i < temp.length; i++) {
            if (Integer.valueOf(temp[i].split("#")[0]) != Integer.valueOf(temp[i - 1].split("#")[0]) + 1) {
                flag = false;
                break;
            }
        }


        if (!flag) {

            flag = true;

           temp =afterChange(array,CHANGE2);

            maopao(temp);
            for (int i = 1; i < temp.length; i++) {
                if (Integer.valueOf(temp[i].split("#")[0]) != Integer.valueOf(temp[i - 1].split("#")[0]) + 1) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }


    public boolean vaid(Item last, String[] next) {
        return vaid(last == null ? null : last.getCard(), next);
    }

    /**
     * 冒泡排序，从小到大
     *
     * @param arr
     */
    public static void maopao(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    //让左边最大
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }


    public static void maopao(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Integer.valueOf(arr[i].split("#")[0]) > Integer.valueOf(arr[j].split("#")[0])) {
                    //让左边最大
                    String temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }


    public static int getMaxValue(String[] v) {
        int value = Integer.valueOf(v[0].split("#")[2]);
        for (int i = 1; i < v.length; i++) {
            int temp = Integer.valueOf(v[i].split("#")[2]);

            if (temp > value) {
                value = temp;
            }
        }
        return value;
    }


    public boolean contains(String[] v, String target) {
        return Arrays.asList(v).contains(target);
    }

}
