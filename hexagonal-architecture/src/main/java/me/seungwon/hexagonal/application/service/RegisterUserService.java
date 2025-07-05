package me.seungwon.hexagonal.application.service;

import lombok.RequiredArgsConstructor;
import me.seungwon.hexagonal.application.port.in.RegisterUserUseCase;
import me.seungwon.hexagonal.application.port.out.SaveUserPort;
import me.seungwon.hexagonal.domain.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {

    private final SaveUserPort saveUserPort;

    @Override
    public User registerUser(User user) {
        // Here you can add any business logic before saving the user
        return saveUserPort.saveUser(user);
    }
}
