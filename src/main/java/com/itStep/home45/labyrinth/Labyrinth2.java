package com.itStep.home45.labyrinth;

import java.util.ArrayList;
import java.util.List;

public class Labyrinth2 {

    private static int[][] cell = new int[7][7];

    public static void main(String[] args) {
        borderCreator();
        cell[1][3] = cell[2][3] = cell[3][2] = cell[3][3] = cell[4][4] = cell[5][2] = 1;
        cell[4][0] = -1;
        printLab();
        dfs(2, 4, new ArrayList<>());
        printLab();
    }

    private static boolean dfs(int x, int y, List<String> visited) {
        if (cell[x][y] == -1) {
            System.out.println(x + " " + y);
            cell[x][y] = 2;
            return true;
        }
        if (cell[x][y] == 1 || visited.contains(x + "" + y)) {
            return false;
        }
        visited.add(x + "" + y);

        int[] k = { 0, 0, -1, 1 };
        int[] l = { -1, 1, 0, 0 };
        int i = 0;
        while (i < 4 && !dfs(x + k[i], y + l[i], visited)) {
            i++;
        }
        if (i >= 4) {
            return false;
        }
        System.out.println(x + " " + y);
        cell[x][y] = 2;
        return true;
    }

    private static void printLab() {
        for (final int[] ints : cell) {
            for (final int anInt : ints) {
                System.out.print((anInt == 1 ? "X" : anInt == 2 ? " O" : " "));
            }
            System.out.println();
        }
    }

    private static void borderCreator() {
        for (int i = 0; i < cell.length; i += cell.length - 1) {
            for (int j = 0; j < cell[i].length; j++) {
                cell[i][j] = 1;
                cell[j][i] = 1;
            }
        }
    }
}
