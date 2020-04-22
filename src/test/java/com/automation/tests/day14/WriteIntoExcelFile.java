package com.automation.tests.day14;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;


public class WriteIntoExcelFile {

    @Test
    public void writeIntoExcelFileTest() throws  IOException {
       FileInputStream inputStream = new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);
        inputStream.close();

        Sheet sheet = workbook.getSheet("QA3-short");
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(5);
        System.out.println(cell.getStringCellValue());
        cell.setCellValue("PASSED");
        System.out.println(cell.getStringCellValue());

        Row newRow = sheet.getRow(0);
        Cell newCell = newRow.createCell(6);
        newCell.setCellValue("Date Of Execution");

        Row row1 = sheet.getRow(1);
        Cell cell1 = row1.createCell(6);
        cell1.setCellValue(LocalDateTime.now().toString());





        FileOutputStream outputStream = new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream);
        workbook.close();


    }

}
