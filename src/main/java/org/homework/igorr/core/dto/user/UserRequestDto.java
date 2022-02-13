package org.homework.igorr.core.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.homework.igorr.core.dto.common.RequestDto;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto extends RequestDto {

    @NotNull
    private Long id;

    public UserRequestDto(String rqId, Long id) {
        super(rqId);
        this.id = id;
    }
}
