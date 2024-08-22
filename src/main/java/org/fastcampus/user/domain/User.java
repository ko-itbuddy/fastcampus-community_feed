package org.fastcampus.user.domain;

import java.util.Objects;
import org.fastcampus.common.domain.PositiveIntegerCounter;

public class User {

    private final Long id;
    private final UserInfo userInfo;
    private final PositiveIntegerCounter followingCount;
    private final PositiveIntegerCounter followerCount;

    public User(Long id, UserInfo userInfo) {
        if(userInfo == null) throw  new IllegalArgumentException();

        this.id = id;
        this.userInfo = userInfo;
        this.followingCount = new PositiveIntegerCounter();
        this.followerCount = new PositiveIntegerCounter();
    }

    public Long getId() {
        return id;
    }

    public void follow(User targetUser){
        if (targetUser.equals(this)) {
            throw new IllegalArgumentException();
        }

        followingCount.increase();
        targetUser.followerCount.increase();
        increaseFollowerCount();
    }

    public void unfollow(User targetUser){
        if (this.equals(targetUser)) {
            throw new IllegalArgumentException();
        }

        followingCount.decrease();
        targetUser.followerCount.decrease();
        decreaseFollowerCount();
    }

    // 디미터의 법칙 점이 두개가 되면 안되가 자기 친구랑만 대화하라
    // 자신의 소유 객체랑만 관여해야지 너무 깊숙히 들어가면 캡슐화가 깨진다.
    private void increaseFollowerCount(){
        followerCount.increase();
    }

    private void decreaseFollowerCount(){
        followerCount.decrease();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public UserInfo getUserInfo() {
        return userInfo;
    }

    public int getFollowingCount() {
        return followingCount.getCount();
    }

    public int getFollowerCount() {
        return followerCount.getCount();
    }
}
