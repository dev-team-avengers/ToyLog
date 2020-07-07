package team.avengers.toylog.model.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import team.avengers.toylog.persistence.h2.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDto {
    private final Integer idx;
    private final String id;
    private final String password;
    private final String profileImage;
    private final String thirdPartyType;
    private final String thirdPartyId;
    private final LocalDateTime registDate;
    private final LocalDateTime updateDate;
    private final LocalDateTime lastLoginDate;

    public static UserResponseDto from(UserEntity userEntity) {
        return new UserResponseDto(
                userEntity.getIdx(),
                userEntity.getId(),
                userEntity.getPassword(),
                userEntity.getProfileImage(),
                Optional.ofNullable(userEntity.getThirdPartyType())
                        .map(Enum::name)
                        .orElse(null),
                userEntity.getThirdPartyId(),
                userEntity.getRegistDate(),
                userEntity.getUpdateDate(),
                userEntity.getLastLoginDate()
        );
    }
}
