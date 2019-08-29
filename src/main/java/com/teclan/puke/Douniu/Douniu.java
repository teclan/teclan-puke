package com.teclan.puke.Douniu;

import com.teclan.puke.Puke;

public  class Douniu extends Puke {


    /**
     * 排序
     *
     * @param card
     * @return
     */
    public static String[] qSort(String[] card, int start, int end) {


        while (card[end]==null){
            end--;
        }

        Integer pivot = Integer.valueOf(card[start].split("-")[2]);
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (Integer.valueOf(card[j].split("-")[2]) > pivot)) {
                j--;
            }
            while ((i < j) && (Integer.valueOf(card[i].split("-")[2]) < pivot)) {
                i++;
            }
            if ((card[i].split("-")[2] == card[j].split("-")[2]) && (i < j)) {
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

}
