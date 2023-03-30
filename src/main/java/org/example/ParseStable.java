package org.example;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ParseStable {

    public static ArrayList<Stable> GetStable(String filename, String group, String date){
        ArrayList<Stable> stableList = new ArrayList<>();
        try {
            //открытие файла
            FileInputStream file = new FileInputStream(filename);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);

            SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
            Date dateR = ft.parse(date);

            Calendar cal = new GregorianCalendar();

            cal.setTime(dateR);

            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            boolean mod = cal.get(Calendar.WEEK_OF_YEAR)%2==0;

            int coordOb = (dayOfWeek-2) * 5;

            System.out.println(coordOb);

            if (mod){
                coordOb = (dayOfWeek-2) * 5;
            }

            System.out.println(coordOb);

            //итерация групп
            for (int i = 5; sheet.getRow(i) != null; i++){
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(0);

                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (group.equals(cell.getRichStringCellValue().getString().trim())) {
                        System.out.println(cell);


                        for (int j = 0; j < 12; j += 2){

                            //проверка на пг
                            if(!sheet.getRow(i + j).getCell(5).toString().equals("")){

                                //1 пг
                                if (sheet.getRow(i + j).getCell(3) != null){
                                    String pg = "1";
                                    if (sheet.getRow(i + j).getCell(5).toString().equals("")) pg = "";
                                    stableList.add(new Stable(cell, sheet.getRow(i + j).getCell(1), pg,
                                            sheet.getRow(i + j).getCell(4 + coordOb),
                                            sheet.getRow(i+j+1).getCell(4 + coordOb),
                                            sheet.getRow(i + j).getCell(5 + coordOb)));
                                }
                                //2 пг
                                if (sheet.getRow(i + j).getCell(6) != null){
                                    String pg = "2";
                                    if (sheet.getRow(i + j).getCell(7).toString().equals("")) pg = "";
                                    stableList.add(new Stable(cell, sheet.getRow(i + j).getCell(1), pg,
                                            sheet.getRow(i + j).getCell(6 + coordOb),
                                            sheet.getRow(i+j+1).getCell(6 + coordOb),
                                            sheet.getRow(i + j).getCell(7 + coordOb)));
                                }
                            } else { //общая пара
                                String pg = "0";
                                if (sheet.getRow(i + j).getCell(7 + coordOb).toString().equals("")) pg = "";
                                stableList.add(new Stable(cell, sheet.getRow(i + j).getCell(1), pg,
                                        sheet.getRow(i + j).getCell(4 + coordOb),
                                        sheet.getRow(i+j+1).getCell(4 + coordOb),
                                        sheet.getRow(i + j).getCell(7 + coordOb)));
                            }
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
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return stableList;
    }
}
