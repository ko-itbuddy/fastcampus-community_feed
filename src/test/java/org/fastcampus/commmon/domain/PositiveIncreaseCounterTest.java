package org.fastcampus.commmon.domain;

import org.fastcampus.common.domain.PositiveIntegerCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositiveIncreaseCounterTest {

    @Test
    void givenCreated_whenIncrease_thenCountIsOne(){
        // given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        // when
        counter.increase();
        // then
        Assertions.assertEquals(1, counter.getCount());
    }

    @Test
    void givenCreated_whenDecrease_thenCountIsZero(){
        // given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        // when
        counter.decrease();
        // then
        Assertions.assertEquals(0, counter.getCount());
    }

}
