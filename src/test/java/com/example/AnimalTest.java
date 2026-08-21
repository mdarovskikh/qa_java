package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    private final Animal animal = new Animal();

    @Test
    void getFamily_ShouldReturnCorrectFamily() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
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
        List<String> food = animal.getFood(animalKind);
        assertTrue(food.contains(expectedFood));
    }
    @ParameterizedTest
    @CsvSource({
            "Травоядное, 2",
            "Хищник, 3"
    })
    void getFood_WithValidKind_ShouldReturnCorrectSize(String animalKind, int expectedSize) throws Exception {
        List<String> food = animal.getFood(animalKind);
        assertEquals(expectedSize, food.size());
    }

    @Test
    void getFood_WithUnknownKind_ShouldThrowException() {
        assertThrows(Exception.class, () -> animal.getFood("Неизвестно"));
    }
}
