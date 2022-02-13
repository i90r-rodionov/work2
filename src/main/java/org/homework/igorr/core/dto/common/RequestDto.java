package org.homework.igorr.core.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class RequestDto implements VersionAware {

    @NotBlank
    private String rqId;

    @Override
    public String getVersion() {
        return "V1";
    }
}
