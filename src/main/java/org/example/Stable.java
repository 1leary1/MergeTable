package org.example;

import org.apache.poi.ss.usermodel.Cell;

public class Stable {
    Cell group;
    Cell lessonNumber;
    int pg;
    Cell lessonName;
    Cell teacher;
    Cell cabinet;

    public Stable(Cell group, Cell lessonNumber, int pg, Cell lessonName, Cell teacher, Cell cabinet) {
        this.group = group;
        this.lessonNumber = lessonNumber;
        this.pg = pg;
        this.lessonName = lessonName;
        this.teacher = teacher;
        this.cabinet = cabinet;
    }
}
