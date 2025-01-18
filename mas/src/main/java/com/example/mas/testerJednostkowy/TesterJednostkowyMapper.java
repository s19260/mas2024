package com.example.mas.testerJednostkowy;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class TesterJednostkowyMapper {
    private ModelMapper modelMapper;

    public TesterJednostkowyDTO toDto(TesterJednostkowy entity){
        return modelMapper.map(entity, TesterJednostkowyDTO.class);
    }

    public TesterJednostkowy toEntity(TesterJednostkowyDTO dto){
        return modelMapper.map(dto, TesterJednostkowy.class);
    }


}
