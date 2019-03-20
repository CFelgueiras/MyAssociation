package Utils;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import net.sf.jasperreports.engine.export.oasis.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CreationHelper;
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
    public static void writeXLS(ArrayList<ArrayList<String>> data,String sheetName)
            throws IOException, InvalidFormatException {
        Workbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet(sheetName);
        CellStyle headerCellStyle = (CellStyle) workbook.createCellStyle();
        Row headerRow = sheet.createRow(0);

        FileOutputStream fileOut = new FileOutputStream("generated.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
}
