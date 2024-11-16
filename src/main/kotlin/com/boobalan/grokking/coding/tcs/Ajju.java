package com.boobalan.grokking.coding.tcs;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ajju {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            line = reader.readLine();
            String[] parts = line.split("\\s+");

            Integer[] numbers = new Integer[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }
            solve(numbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solve(Integer[] pillarHeights) {
        if (pillarHeights.length == 1) {
            byte var1 = 0;
            System.out.println(var1);
        }

        ArrayList<Pillar> pillarsSortedByHeight = new ArrayList<>();
        int i = 0;

        for(int var3 = pillarHeights.length; i < var3; ++i) {
            pillarsSortedByHeight.add(new Pillar(pillarHeights[i], i));
        }


        pillarsSortedByHeight.sort((o1, o2) -> o2.getHeight().compareTo(o1.getHeight()));
        Object var10000 = pillarsSortedByHeight.get(0);
        Pillar leftPillar = (Pillar)var10000;
        var10000 = pillarsSortedByHeight.get(0);
        Pillar rightPillar = (Pillar)var10000;
        int areaToFill = 0;
        int j = 1;

        while(true) {
            int var13 = pillarsSortedByHeight.size();
            if (1 > j) {
                break;
            }

            if (var13 <= j || leftPillar.getPosition() == 0 && rightPillar.getPosition() == pillarHeights.length - 1) {
                break;
            }

            var10000 = pillarsSortedByHeight.get(j++);
            Pillar pillar = (Pillar)var10000;
            if (pillar.getPosition() < leftPillar.getPosition()) {
                areaToFill += pillar.getHeight() * (leftPillar.getPosition() - pillar.getPosition() - 1);
                leftPillar = pillar;
            } else if (pillar.getPosition() > rightPillar.getPosition()) {
                areaToFill += pillar.getHeight() * (pillar.getPosition() - rightPillar.getPosition() - 1);
                rightPillar = pillar;
            } else {
                areaToFill -= pillar.getHeight();
            }
        }

        int restOfSum = 0;
        int k = j;

        for(int var8 = pillarHeights.length; k < var8; ++k) {
            restOfSum += ((Pillar)pillarsSortedByHeight.get(k)).getHeight();
        }

        areaToFill -= restOfSum;
        System.out.println(areaToFill);
    }

    static class Pillar {
        private Integer height;
        private Integer position;

        public Pillar(final Integer height, final Integer position) {
            this.height = height;
            this.position = position;
        }

        public Integer getPosition() {
            return position;
        }

        public void setPosition(final Integer position) {
            this.position = position;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(final Integer height) {
            this.height = height;
        }
    }

}

