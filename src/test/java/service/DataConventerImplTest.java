package service;

import java.util.List;
import model.FruitTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DataConverterImplTest {
    private DataConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DataConverterImpl();
    }

    @Test
    void convert_validData_ok() {
        List<String> input = List.of("b,banana,20");

        List<FruitTransaction> result = converter.convert(input);

        assertEquals(1, result.size());
        assertEquals("banana", result.get(0).getFruit());
        assertEquals(20, result.get(0).getQuantity());
        assertEquals(FruitTransaction.Operation.BALANCE,
                result.get(0).getOperation());
    }
}
