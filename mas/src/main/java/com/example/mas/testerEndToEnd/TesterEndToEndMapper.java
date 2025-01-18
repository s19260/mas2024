package com.example.mas.testerEndToEnd;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class TesterEndToEndMapper {
    private ModelMapper modelMapper;

    public TesterEndToEndDTO toDto(TesterEndToEnd entity){
        return modelMapper.map(entity, TesterEndToEndDTO.class);
    }

    public TesterEndToEnd toEntity(TesterEndToEndDTO dto){
        return modelMapper.map(dto, TesterEndToEnd.class);
    }


}
