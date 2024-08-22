package org.fastcampus.user.application.interfaces;

import org.fastcampus.user.domain.User;

public interface UserRelationRepository {

    boolean isAlreadyFollow(User uer, User targetUser);
    void save(User user, User tartgetUser);
    void delete(User user, User targetUser);
}
