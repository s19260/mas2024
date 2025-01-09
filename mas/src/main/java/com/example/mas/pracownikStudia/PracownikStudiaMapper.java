package com.example.mas.pracownikStudia;

import com.example.mas.projektGry.ProjektGry;
import com.example.mas.projektGry.ProjektGryDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PracownikStudiaMapper {
    private ModelMapper modelMapper;

    public PracownikStudiaDTO toDto(PracownikStudia entity){
        return modelMapper.map(entity, PracownikStudiaDTO.class);
    }

    public PracownikStudia toEntity(PracownikStudiaDoZapisuDTO dto){
        return modelMapper.map(dto, PracownikStudia.class);
    }

}
