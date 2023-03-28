package org.example;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ParseChanges {

    public static ArrayList<Changes> GetChaiges(String filename, String group, String date){
        ArrayList<Changes> changesList = new ArrayList<>();
        try {
            //открытие файла
            FileInputStream file = new FileInputStream(filename);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(date);

            //итерация групп
            for (int i = 5; sheet.getRow(i) != null; i++){
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(0);

                //сбор изменений
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (group.equals(cell.getRichStringCellValue().getString().trim())) {
                        System.out.println(cell);
                        //сбор изменений в обьект
                        changesList.add(new Changes(row.getCell(0), row.getCell(1), row.getCell(2), row.getCell(6)
                                ,row.getCell(7), row.getCell(8), row.getCell(9)));
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
        return changesList;
    }
}
