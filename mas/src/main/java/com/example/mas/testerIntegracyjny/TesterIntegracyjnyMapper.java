package com.example.mas.testerIntegracyjny;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class TesterIntegracyjnyMapper {
    private ModelMapper modelMapper;

    public TesterIntegracyjnyDTO toDto(TesterIntegracyjny entity){
        return modelMapper.map(entity, TesterIntegracyjnyDTO.class);
    }

    public TesterIntegracyjny toEntity(TesterIntegracyjnyDTO dto){
        return modelMapper.map(dto, TesterIntegracyjny.class);
    }


}
