package com.teclan.puke.desk;

import com.teclan.puke.model.Item;

import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 每台桌子的出牌记录缓存
 */
public class DeskCache {

    private static Map<String, Stack<Item>> CACHE = new ConcurrentHashMap<String, Stack<Item>>();


    public static void push(String deskId, Item item) {
        Stack<Item> stack = getStack(deskId);
        stack.push(item);
    }

    private static Stack<Item> getStack(String deskId) {

        Stack<Item> stack = CACHE.get(deskId);

        if (stack == null) {

            stack = new Stack<Item>();

        }
        return stack;
    }

}
