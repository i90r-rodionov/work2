package org.homework.igorr.core.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.homework.igorr.core.dto.common.ItemResponseDto;
import org.homework.igorr.core.dto.common.ResponseStatusDto;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto extends ItemResponseDto<UserDto> {

    public UserResponseDto(String rqId, ResponseStatusDto status, UserDto item) {
        super(rqId, status, item);
    }

    public static UserResponseDto success(UserDto item, String rqId) {
        return new UserResponseDto(rqId, ResponseStatusDto.success(), item);
    }

    public static UserResponseDto error(String rqId, Throwable ex) {
        return new UserResponseDto(rqId, ResponseStatusDto.error(ex), null);
    }
}
