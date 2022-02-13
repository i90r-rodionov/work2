package org.homework.igorr.core.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateDto extends UserBaseRequestDto {

    public UserCreateDto(String rqId, UserDto userDto) {
        super(rqId, userDto);
    }
}
