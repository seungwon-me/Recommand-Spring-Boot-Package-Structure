package me.seungwon.clean.application.service;

import me.seungwon.clean.application.port.in.CreateUserUseCase;
import me.seungwon.clean.application.port.out.SaveUserPort;
import me.seungwon.clean.domain.model.User;

public class CreateUserService implements CreateUserUseCase {

    private final SaveUserPort saveUserPort;

    public CreateUserService(SaveUserPort saveUserPort) {
        this.saveUserPort = saveUserPort;
    }

    @Override
    public User createUser(User user) {
        return saveUserPort.saveUser(user);
    }
}
