package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReportGeneratorImplTest {
    private ReportGenerator reportGenerator;

    @BeforeEach
    void setUp() {
        reportGenerator = new ReportGeneratorImpl();
        Storage.storage.clear();
    }

    @Test
    void getReport_validStorage_ok() {
        Storage.storage.put("banana", 10);
        Storage.storage.put("apple", 5);

        String actual = reportGenerator.getReport();

        assertTrue(actual.contains("banana,10"));
        assertTrue(actual.contains("apple,5"));
    }
}
