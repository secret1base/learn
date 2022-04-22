package file.word;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * doc、docx文字内容读取工具
 * @author: wyj
 * @date: 2021/07/13
 */
public class WORDReader {
    /**
     * doc文件流读取
     * @param fs
     * @return
     * @throws IOException
     */
    public static String docToString(FileInputStream fs){
        try {
            StringBuilder result = new StringBuilder();
            WordExtractor re = new WordExtractor(fs);
            result.append(re.getText());
            re.close();
            return result.toString();
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String docToString(File file) throws FileNotFoundException {
        return docToString(new FileInputStream(file));
    }

    /**
     * docx文件流读取
     * @param fs
     * @return
     * @throws IOException
     * @throws OpenXML4JException
     * @throws XmlException
     */
    public static String docxToString(FileInputStream fs){
        try {
            StringBuilder result = new StringBuilder();
            OPCPackage opcPackage = OPCPackage.open(fs);
            POIXMLTextExtractor re = new XWPFWordExtractor(opcPackage);
            result.append(re.getText());
            re.close();
            return result.toString();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public static String docxToString(File file) throws FileNotFoundException {
        return docxToString(new FileInputStream(file));
    }

    public static void main(String[] args) throws IOException, OpenXML4JException, XmlException {
        File docx = new File("C:\\\\Users\\\\Lenovo\\\\Desktop\\\\aaa.docx");
        System.out.println(docxToString(docx));
        File doc = new File("C:\\\\Users\\\\Lenovo\\\\Desktop\\\\bbb.doc");
        System.out.println(docToString(doc));

    }
}