package team.avengers.toylog.persistence.h2.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import team.avengers.toylog.persistence.h2.entity.TestEntity;

import static org.assertj.core.api.BDDAssertions.*;

@DataJpaTest
@ActiveProfiles(value = "dev")
class TestRepositoryTest {
    @Autowired
    private TestRepository testRepository;
    private TestEntity saveTestEntity;

    @BeforeEach
    void setUp() throws Exception {
        saveTestEntity = testRepository.save(
                TestEntity.builder()
                        .name("lee")
                        .build());
    }

    @Test
    void 이름으로_데이터_조회() {
        assertThat(testRepository.findByName("lee")).containsOnly(saveTestEntity);
    }
}