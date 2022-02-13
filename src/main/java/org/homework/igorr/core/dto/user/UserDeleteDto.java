package org.homework.igorr.core.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDeleteDto extends UserRequestDto {

    public UserDeleteDto(String rqId, Long id) {
        super(rqId, id);
    }
}
