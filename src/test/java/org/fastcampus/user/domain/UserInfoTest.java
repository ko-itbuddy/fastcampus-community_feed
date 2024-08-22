package org.fastcampus.user.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserInfoTest {

    @Test
    void givenNameAndProfileImage_whenCreated_thenThrowNothing(){
        // given
        String name = "abcd";
        String profileImageUrl = "";

        // when
        // then
        Assertions.assertDoesNotThrow(()->new UserInfo(name,profileImageUrl));
    }

    @Test
    void givenBlankNameAndProfileImage_whenCreated_thenThrowNothing(){
        // given
        String name = "";
        String profileImageUrl = "";

        // when
        // then
        Assertions.assertThrows(IllegalArgumentException.class,()->new UserInfo(name,profileImageUrl));
    }

}
