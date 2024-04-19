package ada.tech.quero.ser.dev.service;

import ada.tech.quero.ser.dev.domain.dto.entities.Aluno;
import ada.tech.quero.ser.dev.domain.dto.exception.NotFoundException;
import ada.tech.quero.ser.dev.domain.dto.mappers.AlunoMapper;
import ada.tech.quero.ser.dev.domain.dto.v2.AlunoDto;
import ada.tech.quero.ser.dev.repositories.AlunoRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class AlunoServicoBD implements IAlunoService {

    private AlunoRepository repositorio;

    public AlunoServicoBD(AlunoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public AlunoDto criarAluno(AlunoDto pedido) {
        Aluno p = AlunoMapper.toEntity(pedido);

        return AlunoMapper.toDto(repositorio.save(p));
    }

    @Override
    public List<AlunoDto> listarAlunos() {

        return repositorio.findAll().stream().map(AlunoMapper::toDto).toList();
    }

    @Override
    public AlunoDto buscarAluno(int id) throws NotFoundException {
        return AlunoMapper.toDto(buscarAlunoPorId(id));

    }

    @Override
    public AlunoDto atualizarAluno(int id, AlunoDto pedido) throws NotFoundException {
        final Aluno p = buscarAlunoPorId(id);
        p.setCpf(pedido.getCpf());
        p.setNome(pedido.getNome());
        p.setEmail(pedido.getEmail());
        return AlunoMapper.toDto(repositorio.save(p));
    }

    @Override
    public void removerAluno(int id) throws NotFoundException {
        final Aluno p = buscarAlunoPorId(id);
        repositorio.delete(p);
        repositorio.deleteById(id);
    }

    private Aluno buscarAlunoPorId(int id) throws NotFoundException {
        return repositorio.findById(id).orElseThrow(() -> new NotFoundException(Aluno.class, String.valueOf(id)));
    }

    @Override
    public AlunoDto buscarPorCpf(String cpf) throws NotFoundException {
        return AlunoMapper.toDto(repositorio.findByCpf(cpf).orElseThrow(() -> new NotFoundException(Aluno.class, cpf)));
    }
}