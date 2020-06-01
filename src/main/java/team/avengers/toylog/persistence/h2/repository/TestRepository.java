package team.avengers.toylog.persistence.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.avengers.toylog.persistence.h2.entity.TestEntity;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {
    List<TestEntity> findByName(String name);
}
