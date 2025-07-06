package me.seungwon.onion.application.service;

import me.seungwon.onion.application.port.in.RegisterUserUseCase;
import me.seungwon.onion.application.port.out.UserRepositoryPort;
import me.seungwon.onion.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegisterUserService implements RegisterUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public RegisterUserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User registerUser(RegisterUserCommand command) {
        User user = new User(UUID.randomUUID().toString(), command.getName());
        return userRepositoryPort.save(user);
    }
}
