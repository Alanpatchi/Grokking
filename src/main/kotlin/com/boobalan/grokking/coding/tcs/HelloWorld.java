package com.boobalan.grokking.coding.tcs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HelloWorld {

    static String originalString="abcabc";

    public static int levelCount(String word){

        int maxLevel = 0;
        int level = 0;
        /*write your code here and return appropriate value*/
        for (char c : word.toCharArray()) {
            if (c == '{') {
                level++;
            } else if (c == '}') {
                maxLevel = Math.max(level, maxLevel);
                level--;
            }
            else if ( c == '[') {
                level++;
            } else if (c == ']' ) {
                maxLevel = Math.max(level, maxLevel);
                level--;
            }
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        System.out.println(levelCount("{\"0\":{\"name\":\"[John]\"}\",\"1\":{\"name\":\"[micheal]\"}}"));
    }
}
