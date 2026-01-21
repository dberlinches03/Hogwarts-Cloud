package org.accesodatos.hogwarts.mapper;

import org.accesodatos.hogwarts.dto.CasaDTO;
import org.accesodatos.hogwarts.dto.ProfesorDTO;
import org.accesodatos.hogwarts.model.Casa;

import java.util.List;
import java.util.stream.Collectors;

public class CasaMapper {

    public static CasaDTO toDto(Casa casa) {
        CasaDTO dto = new CasaDTO();
        dto.setId(casa.getIdCasa());
        dto.setNombre(casa.getNombre());
        dto.setFundador(casa.getFundador());
        dto.setFantasma(casa.getFantasma());

        ProfesorDTO jefeDto = ProfesorMapper.toDto(casa.getJefe());
        dto.setJefe(jefeDto);

        List<String> estudiantes = casa.getEstudiantes()
                .stream()
                .map(s -> s.getNombre() + " " + s.getApellido())
                .collect(Collectors.toList());
        dto.setEstudiantes(estudiantes);

        return dto;
    }
}
