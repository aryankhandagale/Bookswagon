package com.bookswagon.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static com.bookswagon.base.BaseClass.driver;

public class TestUtil {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public static String TestDataPath = "C:\\Aryan\\Bookswagon\\src\\main\\java\\com\\bookswagon\\testdata\\Bookswagon Test Data.xlsx";

    static Workbook book;
    static Sheet sheet;

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TestDataPath);
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i + 1);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                data[i][j] = row.getCell(j).toString();
            }
        }

        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public void failedTest(String FailedName) throws IOException {
        TakesScreenshot ss = (TakesScreenshot) driver;
        File SFile = ss.getScreenshotAs(OutputType.FILE);
        File DFile = new File(".\\Screenshots\\" + FailedName + ".png");
        FileHandler.copy(SFile, DFile);
    }
}
