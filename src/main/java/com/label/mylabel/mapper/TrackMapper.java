package com.label.mylabel.mapper;

import com.label.mylabel.entity.TrackEntity;
import com.label.mylabel.model.Track;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TrackMapper {

    Track toDto(TrackEntity trackEntity);

    List<Track> toDtoList(List<TrackEntity> trackEntities);
}
