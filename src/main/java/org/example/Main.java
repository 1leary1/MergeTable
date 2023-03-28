package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //ArrayList<Changes> changesArrayList = ParseChanges.GetChaiges("izm.xlsx", "ТЭМ-50", "28.03.2023");
        //
        //for (int i = 0; i < changesArrayList.size(); i++){
        //    System.out.println(changesArrayList.get(i).lessonNameNew);
        //}

        ParseStable.GetStable("post.xlsx","ТЭМ-50","28.03.2023");
    }
}