package strategy;

import model.FruitTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.Storage;

import static org.junit.jupiter.api.Assertions.*;

class SupplyOperationTest {
    private OperationHandler handler;

    @BeforeEach
    void setUp() {
        handler = new SupplyOperation();
        Storage.storage.clear();
    }

    @Test
    void apply_validSupply_ok() {
        FruitTransaction transaction =
                new FruitTransaction(FruitTransaction.Operation.SUPPLY,
                        "apple", 20);

        handler.apply(transaction);

        assertEquals(20, Storage.storage.get("apple"));
    }
}
