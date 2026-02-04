package strategy;

import model.FruitTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.Storage;

import static org.junit.jupiter.api.Assertions.*;

class ReturnOperationTest {
    private OperationHandler handler;

    @BeforeEach
    void setUp() {
        handler = new ReturnOperation();
        Storage.storage.clear();
        Storage.storage.put("banana", 10);
    }

    @Test
    void apply_validReturn_ok() {
        FruitTransaction transaction =
                new FruitTransaction(FruitTransaction.Operation.RETURN,
                        "banana", 5);

        handler.apply(transaction);

        assertEquals(15, Storage.storage.get("banana"));
    }
}
