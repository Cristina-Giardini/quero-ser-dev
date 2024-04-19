package ada.tech.quero.ser.dev.service;

import ada.tech.quero.ser.dev.domain.dto.exception.NotFoundException;
import ada.tech.quero.ser.dev.domain.dto.v2.AlunoDto;

import java.util.List;

public interface IAlunoService {

    AlunoDto criarAluno(AlunoDto pedido);

    List<AlunoDto> listarAlunos();

    AlunoDto buscarAluno(int id) throws NotFoundException;

    AlunoDto atualizarAluno(int id, AlunoDto pedido) throws NotFoundException;

    void removerAluno(int id) throws NotFoundException;

    AlunoDto buscarPorCpf(String cpf) throws NotFoundException;
}
