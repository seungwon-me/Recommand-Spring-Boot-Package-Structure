package me.seungwon.hexagonal.application.port.out;

import me.seungwon.hexagonal.domain.model.User;

public interface SaveUserPort {
    User saveUser(User user);
}
