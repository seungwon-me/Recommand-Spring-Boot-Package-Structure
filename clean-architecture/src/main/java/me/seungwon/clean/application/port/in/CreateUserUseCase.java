package me.seungwon.clean.application.port.in;

import me.seungwon.clean.domain.model.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
