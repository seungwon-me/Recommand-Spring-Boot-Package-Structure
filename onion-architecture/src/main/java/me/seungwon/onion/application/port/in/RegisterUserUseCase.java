package me.seungwon.onion.application.port.in;

import me.seungwon.onion.domain.model.User;

public interface RegisterUserUseCase {
    User registerUser(RegisterUserCommand command);

    class RegisterUserCommand {
        private String name;

        public RegisterUserCommand(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
