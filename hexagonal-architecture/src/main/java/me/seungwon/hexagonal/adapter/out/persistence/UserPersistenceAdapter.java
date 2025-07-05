package me.seungwon.hexagonal.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import me.seungwon.hexagonal.application.port.out.SaveUserPort;
import me.seungwon.hexagonal.domain.model.User;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements SaveUserPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User saveUser(User user) {
        UserJpaEntity userJpaEntity = new UserJpaEntity();
        // In a real application, you would use a mapper here
        userJpaEntity.setName(user.getName());
        userJpaEntity.setEmail(user.getEmail());

        UserJpaEntity savedUser = userJpaRepository.save(userJpaEntity);

        // In a real application, you would use a mapper here
        user.setId(savedUser.getId());

        return user;
    }
}
