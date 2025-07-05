package me.seungwon.clean.application.port.out;

import me.seungwon.clean.domain.model.User;

public interface SaveUserPort {
    User saveUser(User user);
}
