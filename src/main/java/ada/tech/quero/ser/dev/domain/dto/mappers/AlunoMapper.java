package ada.tech.quero.ser.dev.domain.dto.mappers;

import ada.tech.quero.ser.dev.domain.dto.entities.Aluno;
import ada.tech.quero.ser.dev.domain.dto.v2.AlunoDto;

public class AlunoMapper {

    public static Aluno toEntity(AlunoDto dto) {
        return Aluno
                .builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .email(dto.getEmail())
                .build();


    }

    public static AlunoDto toDto(Aluno entity) {
        return new AlunoDto(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail()

        );
    }
}