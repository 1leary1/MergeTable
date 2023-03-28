package org.example;

import org.apache.poi.ss.usermodel.Cell;

public class Changes {
    Cell group;
    Cell lessonNumber;
    Cell pgPast;
    Cell pgNew;
    Cell lessonNameNew;
    Cell teacherNew;
    Cell cabinet;

    public Changes(Cell group, Cell lessonNumber, Cell pgPast, Cell pgNew, Cell lessonNameNew, Cell teacherNew, Cell cabinet) {
        this.group = group;
        this.lessonNumber = lessonNumber;
        this.pgPast = pgPast;
        this.pgNew = pgNew;
        this.lessonNameNew = lessonNameNew;
        this.teacherNew = teacherNew;
        this.cabinet = cabinet;
    }
}
