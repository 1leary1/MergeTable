package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //ArrayList<Changes> changesArrayList = ParseChanges.GetChaiges("izm.xlsx", "ТЭМ-50", "28.03.2023");
        //
        //for (int i = 0; i < changesArrayList.size(); i++){
        //    System.out.println(changesArrayList.get(i).lessonNameNew);
        //}

        //ParseStable.GetStable("post.xlsx","БХ1-30","28.03.2023");

        ArrayList<Stable> stableArrayList = ParseStable.GetStable("post.xlsx","ТЭМ-50","28.03.2023");
        stableArrayList.get(0);

        System.out.println("гр: " + stableArrayList.get(0).group);
        System.out.println("номерпры: " + stableArrayList.get(0).lessonNumber);
        System.out.println("пг: " + stableArrayList.get(0).pg);
        System.out.println("пред: " + stableArrayList.get(0).lessonName);
        System.out.println("Препод: " + stableArrayList.get(0).teacher);
        System.out.println("каб: " + stableArrayList.get(0).cabinet + "\n \n");

        System.out.println("гр: " + stableArrayList.get(1).group);
        System.out.println("номерпры: " + stableArrayList.get(1).lessonNumber);
        System.out.println("пг: " + stableArrayList.get(1).pg);
        System.out.println("пред: " + stableArrayList.get(1).lessonName);
        System.out.println("Препод: " + stableArrayList.get(1).teacher);
        System.out.println("каб: " + stableArrayList.get(1).cabinet);
        //БХ1-30
    }
}