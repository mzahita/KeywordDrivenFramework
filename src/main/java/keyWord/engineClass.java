package keyWord;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class engineClass {
    public WebDriver driver;



    String elementFilePath = "/Users/mzahita/Desktop/TechnoStudy/Maven Days/keywordDrivenFramework/src/main/java/AllElements/AllElements.xlsx";



    public WebElement findingElementMethod(String sheetName, String elementName){

        WebElement resultElement = null;

        FileInputStream inputStream = null;
        Workbook book = null;
        Sheet sheet = null;

        try {
            inputStream = new FileInputStream(elementFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);
        String locatorType = null;
        String locaterValue = null;

        for (int i = 0 ; i < sheet.getLastRowNum() ; i++){

            String elmentNameFromExcel = sheet.getRow(i+1).getCell(0).toString().trim();

            if (elmentNameFromExcel.equalsIgnoreCase(elementName)){

                locatorType = sheet.getRow(i+1).getCell(1).toString().trim();
                locaterValue = sheet.getRow(i+1).getCell(2).toString().trim();
                break;

            }

            }
        switch (locatorType){

            case"id":
                resultElement = driver.findElement(By.id(locaterValue));
                break;


            case"xpath":
                resultElement = driver.findElement(By.xpath(locaterValue));
                break;

            case"cssSelector":
                resultElement = driver.findElement(By.cssSelector(locaterValue));
                break;



        }

        return resultElement;
    }

}
