package com.example.mas.liderZespolu;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class LiderZespoluMapper {
    private ModelMapper modelMapper;

    public LiderZespoluDTO toDto(LiderZespolu entity){
        return modelMapper.map(entity, LiderZespoluDTO.class);
    }

    public LiderZespolu toEntity(LiderZespoluDTO dto){
        return modelMapper.map(dto, LiderZespolu.class);
    }


}
