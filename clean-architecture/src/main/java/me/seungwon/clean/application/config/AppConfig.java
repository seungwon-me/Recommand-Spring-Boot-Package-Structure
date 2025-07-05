package me.seungwon.clean.application.config;

import me.seungwon.clean.application.port.in.CreateUserUseCase;
import me.seungwon.clean.application.port.out.SaveUserPort;
import me.seungwon.clean.application.service.CreateUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(SaveUserPort saveUserPort) {
        return new CreateUserService(saveUserPort);
    }
}
