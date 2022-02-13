package org.homework.igorr.core.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto implements VersionAware {

    private String rqId;
    private ResponseStatusDto status;

    @Override
    public String getVersion() {
        return "V1";
    }

}
