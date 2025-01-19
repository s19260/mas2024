package com.example.mas.gra;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GraMapper {
    private ModelMapper modelMapper;

    public GraDTO toDto(Gra entity){
        return modelMapper.map(entity, GraDTO.class);
    }

    public Gra toEntity(GraDTO dto){
        return modelMapper.map(dto, Gra.class);
    }

}

