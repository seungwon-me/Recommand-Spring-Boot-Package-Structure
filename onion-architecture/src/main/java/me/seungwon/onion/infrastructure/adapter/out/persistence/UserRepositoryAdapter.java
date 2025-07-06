package me.seungwon.onion.infrastructure.adapter.out.persistence;

import me.seungwon.onion.application.port.out.UserRepositoryPort;
import me.seungwon.onion.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User save(User user) {
        UserJpaEntity userJpaEntity = new UserJpaEntity(user.getId(), user.getName());
        UserJpaEntity savedEntity = userJpaRepository.save(userJpaEntity);
        return new User(savedEntity.getId(), savedEntity.getName());
    }
}
