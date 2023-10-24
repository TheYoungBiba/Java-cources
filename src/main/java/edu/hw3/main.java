package edu.hw3;

import java.awt.List;
import java.util.LinkedList;

public class main {
    public static void main(String[] args) {
        try {
            LinkedList<String> clusters = new LinkedList<>(Task2.clusterize("((())())(()(()()))"));
            for (String cluster : clusters) {
                System.out.println(cluster);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
