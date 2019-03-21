package Utils;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Francisco Martins<fcmartins@lastsoftware.pt>
 */
public class ExportUtils {
     
    /**
     * UNDER DEVELOPMENT.
     */    
    private static void initWriter(){
        
    }
    
    /**
     * UNDER DEVELOPMENT.
     */
    private static void buildWorkbock(){
        
    }
    
    /**
     * UNDER DEVELOPMENT.
     * 
     * @param data
     * @param sheetName
     * @throws IOException
     * @throws InvalidFormatException 
     */
    public static void writeXLS(
            ArrayList<ArrayList<String>> data,String sheetName
    )
            throws IOException, InvalidFormatException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(sheetName);
            Integer rowCount = 0;
            Integer cellCount = 0;
            for(ArrayList<String> rowIt: data) {
                Row newRow = sheet.createRow(rowCount);
                for(String cellIt : rowIt){
                    Cell cell = newRow.createCell(cellCount);
                    cell.setCellValue(cellIt);
                    cellCount++;
                }
                rowCount++;
            }
            try (FileOutputStream fileOut = new FileOutputStream("generated.xlsx")) {
                workbook.write(fileOut);
            }
        }
    }
}
