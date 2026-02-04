package core.basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import core.basesyntax.model.FruitTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataConverterImplTest {
    private DataConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DataConverterImpl();
    }

    @Test
    void convert_validData_ok() {
        List<String> input = List.of(
