package file.word;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * xls、xlsx文字内容读取工具
 * @author: wyj
 * @date: 2021/07/13
 */
public class EXCELReader {

    public static String xlsToString (String filePath) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(filePath);
        return xlsToString(fileInputStream);
    }
    /**
     * 用于文件检索使用，因此需要读取excel中的所有数据
     * @param fileInputStream
     * @return
     * @throws IOException
     */
    public static String xlsToString (FileInputStream fileInputStream) {
        try {
            StringBuilder sb=new StringBuilder();
            HSSFWorkbook sheets = new HSSFWorkbook(fileInputStream);
            //获取sheet
            for (Sheet sheet : sheets) {
                for (Row row:sheet) {
                    for (Cell cell : row) {
                        String val = null;
                        if (cell.getCellType().getCode() == Excel.CELL_TYPE_NUMERIC) {
                            // val = cell.getNumericCellValue();
                            // 当excel 中的数据为数值或日期是需要特殊处理
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                double d = cell.getNumericCellValue();
                                Date date = HSSFDateUtil.getJavaDate(d);
                                SimpleDateFormat dformat = new SimpleDateFormat(
                                        "yyyy-MM-dd");
                                val = dformat.format(date);
                            } else {
                                NumberFormat nf = NumberFormat.getInstance();
                                nf.setGroupingUsed(false);// true时的格式：1,234,567,890
                                val = nf.format(cell.getNumericCellValue());// 数值类型的数据为double，所以需要转换一下
                            }
                        } else if (cell.getCellType().getCode() == Excel.CELL_TYPE_STRING) {
                            val = cell.getStringCellValue();
                        } else if (cell.getCellType().getCode() == Excel.CELL_TYPE_FORMULA) {
                            val = cell.getCellFormula();
                        } else if (cell.getCellType().getCode() == Excel.CELL_TYPE_BOOLEAN) {
                            val = Boolean.toString(cell.getBooleanCellValue());
                        } else if (cell.getCellType().getCode() == Excel.CELL_TYPE_ERROR) {
                            val = String.valueOf(cell.getErrorCellValue());
                        }
                        sb.append(val).append("\n");
                    }
                }
            }
            return sb.toString();
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static String xlsxToString (String filePath) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(filePath);
        return xlsxToString(fileInputStream);
    }
    public static String xlsxToString (FileInputStream fileInputStream ) {
        try {
            StringBuilder sb=new StringBuilder();
            XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
            //获取sheet
            for (Sheet sheet : sheets) {
                for (Row row:sheet) {
                    for (Cell cell : row) {
                        String val = null;
                        if (cell.getCellType().getCode() == Excel.CELL_TYPE_NUMERIC) {
                            // val = cell.getNumericCellValue();
                            // 当excel 中的数据为数值或日期是需要特殊处理
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                double d = cell.getNumericCellValue();
                                Date date = HSSFDateUtil.getJavaDate(d);
                                SimpleDateFormat dformat = new SimpleDateFormat(
                                        "yyyy-MM-dd");
                                val = dformat.format(date);
                            } else {
                                NumberFormat nf = NumberFormat.getInstance();
                                nf.setGroupingUsed(false);// true时的格式：1,234,567,890
                                val = nf.format(cell.getNumericCellValue());// 数值类型的数据为double，所以需要转换一下
                            }
                        } else if (cell.getCellType().getCode() == Excel.CELL_TYPE_STRING) {
                            val = cell.getStringCellValue();
                        } else if (cell.getCellType().getCode() == Excel.CELL_TYPE_FORMULA) {
                            val = cell.getCellFormula();
                        } else if (cell.getCellType().getCode() == Excel.CELL_TYPE_BOOLEAN) {
                            val = Boolean.toString(cell.getBooleanCellValue());
                        } else if (cell.getCellType().getCode() == Excel.CELL_TYPE_ERROR) {
                            val = String.valueOf(cell.getErrorCellValue());
                        }
                        sb.append(val).append("\n");
                    }
                }
            }
            return sb.toString();
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        String xls = xlsToString("C:\\Users\\Lenovo\\Desktop\\kkk.xls");
        System.out.println(xls);
        String xlsx = xlsxToString("C:\\Users\\Lenovo\\Desktop\\jjj.xlsx");
        System.out.println(xlsx);
    }
}
