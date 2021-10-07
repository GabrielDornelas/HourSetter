package com.zallpy.hoursetter;

import com.zallpy.hoursetter.entity.User;
import com.zallpy.hoursetter.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback()
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testeCreateUser() {
        User user = new User();
        user.setEmail("zerick.gd@gmail.com");
        user.setPassword("senha123");
        user.setName("Gabriel Dornelas");

        User savedUser = userRepository.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(existUser.getId()).isEqualTo(user.getId());
        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(existUser.getPassword()).isEqualTo(user.getPassword());
        assertThat(existUser.getName()).isEqualTo(user.getName());
    }
}
