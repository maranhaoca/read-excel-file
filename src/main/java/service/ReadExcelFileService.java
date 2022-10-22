package service;

import lombok.Cleanup;
import model.Input;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcelFileService {
    public static List<Input> readExcelFile(String path) throws IOException {
        List<Input> inputs = new ArrayList<>();
        //create a file
        @Cleanup
        FileInputStream file = new FileInputStream(path);

        Workbook workbook = new HSSFWorkbook(file);
        //set sheet
        Sheet sheet = workbook.getSheetAt(0);
        //set rows
        List<Row> rows = (List<Row>) toList(sheet.iterator());
        //remove header
        rows.subList(0, 5).clear();
        //traversing rows
        rows.forEach(row -> {
            //set cells
            List<Cell> cells = (List<Cell>) toList(row.cellIterator());
            //add cells as object parameters
            Input input = Input.builder()
                    .macroClass(cells.get(0).getStringCellValue())
                    .macroClasseDescription(cells.get(1).getStringCellValue())
                    .classe(cells.get(2).getStringCellValue())
                    .classeDescription(cells.get(3).getStringCellValue())
                    .type(cells.get(4).getStringCellValue())
                    .typeDescription(cells.get(5).getStringCellValue())
                    .classificationCode(cells.get(6).getStringCellValue())
                    .description(cells.get(7).getStringCellValue())
                    .unity(cells.get(8).getStringCellValue())
                    .priceMedium(cells.get(9).getStringCellValue())
                    .priceOrigin(cells.get(10).getStringCellValue())
                    .institution(cells.get(11).getStringCellValue())
                    .build();

            inputs.add(input);
        });

        return inputs;
    }

    public static List<?> toList(Iterator<?> iterator) {
        return IteratorUtils.toList(iterator);
    }
}
