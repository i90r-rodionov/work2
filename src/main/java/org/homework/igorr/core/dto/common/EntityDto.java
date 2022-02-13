package org.homework.igorr.core.dto.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityDto implements VersionAware, DtoModel {

    private Long id;

    @Override
    public String getVersion() {
        return "V1";
    }

    @Override
    public String toString() {
        return String.format("%s(id=%d)", getClass().getSimpleName(), getId());
    }
}
