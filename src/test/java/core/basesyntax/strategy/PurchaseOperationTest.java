package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PurchaseOperationTest {
    private OperationHandler handler;

    @BeforeEach
    void setUp() {
        handler = new PurchaseOperation();
        Storage.storage.clear();
        Storage.storage.put("banana", 5);
    }

    @Test
    void apply_notEnoughFruits_notOk() {
        FruitTransaction transaction =
                new FruitTransaction(FruitTransaction.Operation.PURCHASE,
                        "banana", 10);

        assertThrows(RuntimeException.class,
                () -> handler.apply(transaction));
    }
}
