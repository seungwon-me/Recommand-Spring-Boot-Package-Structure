package me.seungwon.hexagonal.adapter.in.web;

import lombok.RequiredArgsConstructor;
import me.seungwon.hexagonal.application.port.in.RegisterUserUseCase;
import me.seungwon.hexagonal.domain.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping
    public User registerUser(@RequestBody User user) {
        return registerUserUseCase.registerUser(user);
    }
}
