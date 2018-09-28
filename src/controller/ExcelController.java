package controller;

import model.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static repository.UserRepository.USERS;

/**
 * Created by DORDV on 17.08.2018.
 */
public class ExcelController {
    private XSSFWorkbook workbook;

    public List<User> getAll(String excelFilePath) throws IOException {

        workbook = new XSSFWorkbook(new FileInputStream(new File(excelFilePath)));
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();

        if (rowIterator.hasNext()){
            rowIterator.next();
        }

        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            Cell nameCell = row.getCell(0);
            Cell emailCell = row.getCell(1);
            Cell numberCell = row.getCell(3);
            if (nameCell != null){
                USERS.add(new User(numberCell.toString(), nameCell.toString(), emailCell.toString()));
            }

        }

        return USERS;
    }
}
