package file;

import file.pdf.PDFReader;
import file.word.EXCELReader;
import file.word.WORDReader;

import java.io.FileInputStream;

/**
 * @author: wyj
 * @date: 2021/07/13
 */
public class FileReader {
    public static String readFile(FileInputStream fis,String path){
        String result=null;
        String suffix = path.substring(path.lastIndexOf(".") + 1).toLowerCase();
        if("xls".equals(suffix)){
            result=EXCELReader.xlsToString(fis);
        }else if("xlsx".equals(suffix)){
            result=EXCELReader.xlsxToString(fis);
        }else if("doc".equals(suffix)){
            result=WORDReader.docToString(fis);
        }else if("docx".equals(suffix)){
            result=WORDReader.docxToString(fis);
        }else if("pdf".equals(suffix)){
            result=PDFReader.pdfToString(fis);
        }
        return result;
    }
}
