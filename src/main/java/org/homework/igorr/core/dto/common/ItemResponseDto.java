package org.homework.igorr.core.dto.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemResponseDto<D extends DtoModel> extends ResponseDto {

    private D item;

    public ItemResponseDto(String rqId, ResponseStatusDto status, D item) {
        super(rqId, status);
        this.item = item;
    }

    public static <D extends DtoModel> ItemResponseDto<D> success(D item, String rqId) {
        return new ItemResponseDto<>(rqId, ResponseStatusDto.success(), item);
    }

    public static <D extends DtoModel> ItemResponseDto<D> error(String rqId, Throwable ex) {
        return new ItemResponseDto<>(rqId, ResponseStatusDto.error(ex), null);
    }

}
