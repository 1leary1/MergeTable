package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //ArrayList<Changes> changesArrayList = ParseChanges.GetChaiges("izm.xlsx", "ТЭМ-50", "28.03.2023");
        //
        //for (int i = 0; i < changesArrayList.size(); i++){
        //    System.out.println(changesArrayList.get(i).lessonNameNew);
        //}



        ArrayList<Stable> stableArrayList = ParseStable.GetStable("post.xlsx","БХ1-30","28.03.2023");

        for (int i = 0; i < stableArrayList.size(); i++){
            System.out.println("Пара: " + stableArrayList.get(i).lessonNumber);
            System.out.println("Пг: " + stableArrayList.get(i).pg);
            System.out.println("Пара: " + stableArrayList.get(i).lessonName + "\n");
        }

        //БХ1-30
    }
}