package me.seungwon.hexagonal.application.port.in;

import me.seungwon.hexagonal.domain.model.User;

public interface RegisterUserUseCase {
    User registerUser(User user);
}
