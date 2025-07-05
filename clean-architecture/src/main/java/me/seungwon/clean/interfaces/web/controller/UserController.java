package me.seungwon.clean.interfaces.web.controller;

import me.seungwon.clean.application.port.in.CreateUserUseCase;
import me.seungwon.clean.domain.model.User;
import me.seungwon.clean.interfaces.web.dto.CreateUserRequest;
import me.seungwon.clean.interfaces.web.dto.CreateUserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        User user = new User(request.getName(), request.getEmail());
        User createdUser = createUserUseCase.createUser(user);
        return new CreateUserResponse(createdUser.getId(), createdUser.getName(), createdUser.getEmail());
    }
}
