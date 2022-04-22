package file.pdf;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * pdf文字内容读取工具
 * @author: wyj
 * @date: 2021/07/13
 */
public class PDFReader {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(pdfToString("C:\\Users\\Lenovo\\Desktop\\xxx.pdf"));
        FileInputStream fis=new FileInputStream("C:\\\\Users\\\\Lenovo\\\\Desktop\\\\xxx.pdf");
        System.out.println(pdfToString(fis));
    }

    /**
     * 通过文件流获取pdf内容
     * @param fis
     * @return
     * @throws IOException
     */
    public static String pdfToString(FileInputStream fis){
        try{
            PdfReader reader = new PdfReader(fis);
            PdfReaderContentParser parser = new PdfReaderContentParser(reader);
            StringBuffer buff = new StringBuffer();
            TextExtractionStrategy strategy;
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                strategy = parser.processContent(i,
                        new SimpleTextExtractionStrategy());
                buff.append(strategy.getResultantText());
            }
            return buff.toString();
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过路径获取pdf内容
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String pdfToString(String fileName){
        try{
            PdfReader reader = new PdfReader(fileName);
            PdfReaderContentParser parser = new PdfReaderContentParser(reader);
            StringBuffer buff = new StringBuffer();
            TextExtractionStrategy strategy;
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                strategy = parser.processContent(i,
                        new SimpleTextExtractionStrategy());
                buff.append(strategy.getResultantText());
            }
            return buff.toString();
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
