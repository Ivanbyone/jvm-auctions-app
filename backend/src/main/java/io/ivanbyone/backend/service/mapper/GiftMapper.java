package io.ivanbyone.backend.service.mapper;

import io.ivanbyone.backend.dto.output.GiftOutput;
import io.ivanbyone.backend.model.Gift;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GiftMapper {

    GiftOutput toDto(Gift gift);

    List<GiftOutput> toList(List<Gift> gifts);
}
