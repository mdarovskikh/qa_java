package com.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class LionTest {
@Mock
    private Feline felineMock;

@Test
    void lionConstructor_WithInvalidSex_ShouldThrowException() {
    assertThrows(Exception.class, () -> new  Lion("Неизвестно", felineMock));
}

@Test
    void getKittens_ShouldCallFelineGetKittens() throws Exception {
    Lion lion = new Lion("Самец", felineMock);
    lion.getKittens();
    verify(felineMock).getKittens();
}

@Test
    void getFood_ShouldCallFelineGetFoodWithPredator() throws Exception {
    Lion lion = new Lion("Самец", felineMock);
    lion.getFood();
    verify(felineMock).getFood("Хищник");
}
}
