package ada.tech.quero.ser.dev.domain.dto.mappers;

import ada.tech.quero.ser.dev.domain.dto.entities.Professor;
import ada.tech.quero.ser.dev.domain.dto.v1.ProfessorDto;

public class ProfessorMapper {
    public static Professor toEntity(ProfessorDto dto) {
        return Professor
                .builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .email(dto.getEmail())
                .build();


    }

    public static ProfessorDto toDto(Professor entity) {
        return new ProfessorDto(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail()

        );
    }

}
