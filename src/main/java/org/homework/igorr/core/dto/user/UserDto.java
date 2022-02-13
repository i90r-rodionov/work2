package org.homework.igorr.core.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.homework.igorr.core.dto.common.EntityDto;

@Getter
@Setter
@NoArgsConstructor
public class UserDto extends EntityDto {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
