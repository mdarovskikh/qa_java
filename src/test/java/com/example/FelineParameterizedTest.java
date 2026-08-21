package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineParameterizedTest {
    private final Feline feline = new Feline();

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10})
    void getKittens_WithDifferentCounts_ShouldReturnGivenCount(int kittensCount) {
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }

    @ParameterizedTest
    @CsvSource({
            "Травоядное, Трава",
            "Травоядное, Различные растения",
            "Хищник, Животные",
            "Хищник, Птица",
            "Хищник, Рыба"
    })
    void getFood_WithValidKind_ShouldContainExpectedFood(String animalKind, String expectedFood) throws Exception {
        List<String> food = feline.getFood(animalKind);
        assertTrue(food.contains(expectedFood));
    }

    @ParameterizedTest
    @CsvSource({
            "Травоядное, 2",
            "Хищник, 3"
    })
    void getFood_WithValidKind_ShouldReturnCorrectCount(String animalKind, int expectedSize) throws Exception {
        List<String> food = feline.getFood(animalKind);
        assertEquals(expectedSize, food.size());
    }
}
