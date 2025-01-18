package com.example.mas.tester;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class TesterMapper {
    private ModelMapper modelMapper;

    public TesterDTO toDto(Tester entity){
        return modelMapper.map(entity, TesterDTO.class);
    }

    public Tester toEntity(TesterDTO dto){
        return modelMapper.map(dto, Tester.class);
    }


}
