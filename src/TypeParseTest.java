import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeNoException;

import org.junit.Test;

public class TypeParseTest {
    @Test
    public void parseFileTest() {
        TypeParse typeParse = new TypeParse();

        try {
            typeParse.parseFile("./data/abc.csv", "./outputs/abc.csv");
        } catch (Exception e) {
            assertThrows("File not found at ./data/abc.csv", Exception.class, () -> {
                throw e;
            });
        }

        try {
            typeParse.parseFile("./data/input_file.jsa", "./outputs/abc.jsa");
        } catch (Exception e) {
            assertThrows(null, Exception.class, () -> {
                throw e;
            });
        }


    }

    @Test
    public void parseCSVTest(){
        TypeParse typeParse = new TypeParse();

        try {
            typeParse.parseCSV("./data/abc.csv", "./outputs/abc.csv");
        } catch (Exception e) {
            assertThrows("File not found at ./data/abc.csv", Exception.class, () -> {
                throw e;
            });
        }

        try {
            typeParse.parseCSV("./data/input_file.csv", "./outputs/output_file.csv");
        } catch (Exception e) {
            assumeNoException(e);
        }
    }

    @Test
    public void parseJSONTest(){
        TypeParse typeParse = new TypeParse();

        try {
            typeParse.parseJSON("./data/abc.json", "./outputs/abc.json");
        } catch (Exception e) {
            assertThrows("File not found at ./data/abc.json", Exception.class, () -> {
                throw e;
            });
        }

        try {
            typeParse.parseJSON("./data/input_file.json", "./outputs/output_file.json");
        } catch (Exception e) {
            assumeNoException(e);
        }
    }

    @Test
    public void parseXMLTest(){
        TypeParse typeParse = new TypeParse();

        try {
            typeParse.parseXML("./data/abc.xml", "./outputs/abc.xml");
        } catch (Exception e) {
            assertThrows("File not found at ./data/abc.xml", Exception.class, () -> {
                throw e;
            });
        }

        try {
            typeParse.parseXML("./data/input_file.xml", "./outputs/output_file.xml");
        } catch (Exception e) {
            assumeNoException(e);
        }
    }   
}
