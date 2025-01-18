package com.example.mas.deweloper;

import com.example.mas.projektGry.ProjektGry;
import com.example.mas.projektGry.ProjektGryDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeweloperMapper {
    private ModelMapper modelMapper;

    public DeweloperDTO toDto(Deweloper entity){
        return modelMapper.map(entity, DeweloperDTO.class);
    }

    public Deweloper toEntity(DeweloperDTO dto){
        return modelMapper.map(dto, Deweloper.class);
    }

}
