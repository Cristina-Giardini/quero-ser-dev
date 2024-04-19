package ada.tech.quero.ser.dev.service;

import ada.tech.quero.ser.dev.domain.dto.v1.ProfessorDto;
import ada.tech.quero.ser.dev.domain.dto.exception.NotFoundException;
import java.util.List;

public interface IProfessorService {

    ProfessorDto criarProfessor(ProfessorDto pedido);

    List<ProfessorDto> listarProfessores();

    ProfessorDto buscarProfessor(int id) throws NotFoundException;

    ProfessorDto atualizarProfessor(int id, ProfessorDto pedido) throws NotFoundException;

    void removerProfessor(int id) throws NotFoundException;
    ProfessorDto buscarPorCpf(String cpf) throws NotFoundException;




}
