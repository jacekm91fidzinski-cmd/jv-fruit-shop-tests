package service;

import model.FruitTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitServiceImplTest {
    private FruitService fruitService;

    @BeforeEach
    void setUp() {
        fruitService = new FruitServiceImpl();
        Storage.storage.clear();
    }

    @Test
    void apply_validSupply_ok() {
        FruitTransaction transaction =
                new FruitTransaction(FruitTransaction.Operation.SUPPLY,
                        "apple", 10);

        fruitService.apply(transaction);

        assertEquals(10, Storage.storage.get("apple"));
    }
}
