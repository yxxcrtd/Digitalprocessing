import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hwpf.extractor.WordExtractor;

public class MyWordExtractor {

public static void main(String[] args) {
   File file = new File("d:\\test.doc");
   try {
    FileInputStream fis = new FileInputStream(file);
    WordExtractor wordExtractor = new WordExtractor(fis);
    System.out.println(wordExtractor.getTextFromPieces());
   } catch (FileNotFoundException e) {
    e.printStackTrace();
   } catch (IOException e) {
   e.printStackTrace();
}
}
}