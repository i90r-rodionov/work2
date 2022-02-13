package org.homework.igorr.core.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.homework.igorr.core.dto.common.RequestDto;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class UserBaseRequestDto extends RequestDto {

    private UserDto userDto;

    public UserBaseRequestDto(@NotBlank String rqId, UserDto userDto) {
        super(rqId);
        this.userDto = userDto;
    }
}
