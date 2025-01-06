package com.example.mas.projektGry;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjektGryMapper {
    private ModelMapper modelMapper;

    public ProjektGryDTO toDto(ProjektGry entity){
        return modelMapper.map(entity, ProjektGryDTO.class);
    }

    public ProjektGry toEntity(ProjektGryDTO dto){
        return modelMapper.map(dto, ProjektGry.class);
    }
}
