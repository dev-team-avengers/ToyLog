package team.avengers.toylog.model.test;

import lombok.*;
import team.avengers.toylog.persistence.h2.entity.TestEntity;

@Getter
@ToString
@RequiredArgsConstructor
public class TestAddRequestDto {
    private String name;

    public TestEntity toEntity() {
        return TestEntity.builder()
                .name(name)
                .build();
    }
}
