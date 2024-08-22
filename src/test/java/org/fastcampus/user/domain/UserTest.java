package org.fastcampus.user.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    private final UserInfo userInfo = new UserInfo("test","");
    private final User user1 = new User(1L, userInfo);
    private final User user2 = new User(1L, userInfo);


    @Test
    void givenTwoUser_whenEqual_thenReturnFalse(){
        // given

        boolean isSame = user1.equals(user2);
        // when
        // then
        Assertions.assertFalse(isSame);
    }

    @Test
    void givenTwoSameUser_whenEqual_thenReturnFalse(){
        // given
        String name = "";
        String profileImageUrl = "";

        // when
        // then
        Assertions.assertThrows(IllegalArgumentException.class,()->new UserInfo(name,profileImageUrl));
    }

}
