package team.avengers.toylog.model;

import lombok.*;
import team.avengers.toylog.persistence.h2.entity.TestEntity;

@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TestResponseDto {
    private final Long id;
    private final String name;

    public static TestResponseDto from(TestEntity testEntity) {
        return new TestResponseDto(testEntity.getId(), testEntity.getName());
    }
}
