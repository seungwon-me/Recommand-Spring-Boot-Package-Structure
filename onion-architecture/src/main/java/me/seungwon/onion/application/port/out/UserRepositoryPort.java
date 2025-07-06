package me.seungwon.onion.application.port.out;

import me.seungwon.onion.domain.model.User;

public interface UserRepositoryPort {
    User save(User user);
}
