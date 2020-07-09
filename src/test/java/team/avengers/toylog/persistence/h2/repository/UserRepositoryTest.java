package team.avengers.toylog.persistence.h2.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import team.avengers.toylog.persistence.h2.entity.UserEntity;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles(value = "dev")
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    private UserEntity userEntity;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() throws Exception {
        userEntity =
                UserEntity.builder()
                        .id("test_id")
                        .password("")
                        .build();
        testEntityManager.persist(userEntity);
    }

    @Test
    void id로_유저_조회() {
        Assertions.assertThat(userRepository.findById("test_id"))
                .contains(userEntity);
    }
}