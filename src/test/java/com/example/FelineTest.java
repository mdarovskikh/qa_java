package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class FelineTest {
    private final Feline feline = new Feline();
    @Test
    void eatMeat_ShouldReturnPredatorFood() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Рыба", "Птица"), food);
    }
    @Test
    void getFamily_ShouldRetunrCatFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    void getKittens_ShouldReturnOne() {
        assertEquals(1, feline.getKittens());
    }
    @Test
    void getFood_ShouldThrowException() {
        assertThrows(Exception.class, () -> feline.getFood("Неизвестно"));
    }
}
