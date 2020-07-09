package team.avengers.toylog.persistence.h2.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_tbl", uniqueConstraints = {
        @UniqueConstraint(name = "unique_id", columnNames = "id")
})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Integer idx;

    @Column(name = "id", length = 20, nullable = false)
    private String id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "profile_image")
    private String profileImage;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "third_party_type")
    private ThirdPartyType thirdPartyType;

    @Column(name = "third_party_id")
    private String thirdPartyId;

    @Column(name = "regist_date")
    private final LocalDateTime registDate = LocalDateTime.now();

    @Column(name = "update_date")
    private LocalDateTime updateDate = LocalDateTime.now();

    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;

    public enum ThirdPartyType {
        KAKAO
    }

    @Builder
    public UserEntity(Integer idx, String id, String password) {
        this.idx = idx;
        this.id = id;
        this.password = password;
    }
}
