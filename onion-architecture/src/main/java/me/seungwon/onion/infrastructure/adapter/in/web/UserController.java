package me.seungwon.onion.infrastructure.adapter.in.web;

import me.seungwon.onion.application.port.in.RegisterUserUseCase;
import me.seungwon.onion.domain.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;

    public UserController(RegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping("/users")
    public User registerUser(@RequestBody RegisterUserRequest request) {
        RegisterUserUseCase.RegisterUserCommand command = new RegisterUserUseCase.RegisterUserCommand(request.getName());
        return registerUserUseCase.registerUser(command);
    }

    static class RegisterUserRequest {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
