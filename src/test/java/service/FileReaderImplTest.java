package service;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileReader;


public class FileReaderImplTest {
    private FileReader fileReader;

    @BeforeEach
    void setUp() {
        fileReader = new FileReaderImpl();
    }

    @Test
    void read_validFile_ok() {
        List<String> actual = fileReader.read("src/test/resources/imput.csv");

        assertEquals(3, actual.size());
        assertEquals("b,banana,20", actual.get(0));
    }

    @Test
    void read_fileNotExists_notOK() {
        assertThrows(RuntimeException.class,
                () -> fileReader.read("wrong/path.csv"));
    }
}
