package org.example;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ParseStable {

    public static ArrayList<Stable> GetStable(String filename, String group, String date){
        ArrayList<Stable> stableList = new ArrayList<>();
        try {
            //открытие файла
            FileInputStream file = new FileInputStream(filename);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);

            //итерация групп
            for (int i = 5; sheet.getRow(i) != null; i++){
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(0);

                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (group.equals(cell.getRichStringCellValue().getString().trim())) {
                        System.out.println(cell);

                        //проверка на пг
                        if(!row.getCell(5).toString().equals("")){

                            //1 пг
                            if (row.getCell(3) != null){
                                stableList.add(new Stable(cell, row.getCell(1), 1, row.getCell(4), sheet.getRow(i+1).getCell(4),row.getCell(5)));
                            }
                            //2 пг
                            if (row.getCell(6) != null){
                                stableList.add(new Stable(cell, row.getCell(1), 2, row.getCell(6), sheet.getRow(i+1).getCell(6),row.getCell(7)));
                            }
                        } else {
                            stableList.add(new Stable(cell, row.getCell(1), 0, row.getCell(4), sheet.getRow(i+1).getCell(4),row.getCell(7)));
                        }

                        break;
                    }
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("ошипка файла");
        } catch (IOException e) {
            System.out.println("ошипка иое");
        } catch (InvalidFormatException e) {
            System.out.println("ошипка инвалид");
        }
        return stableList;
    }
}
