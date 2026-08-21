package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatTest {
@Mock
    private Feline felineMock;
@Test
    void getSound_ShouldReturnMeow() {
    Cat cat = new Cat(felineMock);
    assertEquals("Мяу", cat.getSound());
}
@Test
    void getFood_ShouldReturnPredatorFoodFromFeline() throws Exception {
    Cat cat = new Cat(felineMock);
    List<String> expectedFood = List.of("Животное", "Рыба", "Птица");
    when(felineMock.eatMeat()).thenReturn(expectedFood);

    List<String> actualFood = cat.getFood();

    assertEquals(expectedFood, actualFood);
}
}
