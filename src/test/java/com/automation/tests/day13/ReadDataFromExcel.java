package com.automation.tests.day13;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ReadDataFromExcel {

    @Test
    public void readExelFileTest() throws IOException {
        //we need to get a file as an object
        File file = new File("VytrackTestUsers.xlsx");
        //object that represents excel file
        Workbook workbook = WorkbookFactory.create(file);
        //get QA1-short
        Sheet workSheet = workbook.getSheet("QA1-short");
        //get 1st row
        Row firstRow = workSheet.getRow(0);
        //get 1st cell
        Cell firstCell = firstRow.getCell(0);
        //get string value
        String value = firstCell.getStringCellValue();

        String secondCellValue = firstRow.getCell(1).getStringCellValue();

        System.out.println(value);
        System.out.println(secondCellValue);

        int lastCell = firstRow.getLastCellNum();

        for (int i = 0; i <lastCell ; i++) {
            System.out.print(firstRow.getCell(i)+"|");
        }


        int numberOfRows = workSheet.getLastRowNum()+1;
        int numberOfRows2= workSheet.getPhysicalNumberOfRows();
        System.out.println("\nNumber of rows: "+ numberOfRows);
        System.out.println("\nNumber of rows: "+ numberOfRows2);


        System.out.println("##########################");

        for (int row = 0; row < workSheet.getPhysicalNumberOfRows(); row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum(); cell++) {
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.print(cellValue + " | ");
            }
            System.out.println();
        }

    }


}
