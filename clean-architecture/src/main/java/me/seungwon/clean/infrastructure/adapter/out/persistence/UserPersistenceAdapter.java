package me.seungwon.clean.infrastructure.adapter.out.persistence;

import me.seungwon.clean.application.port.out.SaveUserPort;
import me.seungwon.clean.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceAdapter implements SaveUserPort {

    private final UserRepository userRepository;

    public UserPersistenceAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        UserJpaEntity userJpaEntity = new UserJpaEntity(user.getName(), user.getEmail());
        UserJpaEntity savedUser = userRepository.save(userJpaEntity);
        user.setId(savedUser.getId());
        return user;
    }
}
