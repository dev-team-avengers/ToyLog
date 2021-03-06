package team.avengers.toylog.persistence.h2.entity;

import lombok.*;
import team.avengers.toylog.model.test.TestModifyRequestDto;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "test")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Builder
    public TestEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TestEntity update(TestModifyRequestDto testModifyRequestDto) {
        this.name = testModifyRequestDto.getName();
        return this;
    }
}
