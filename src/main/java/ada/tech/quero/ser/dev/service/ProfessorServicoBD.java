package ada.tech.quero.ser.dev.service;

import ada.tech.quero.ser.dev.domain.dto.entities.Professor;
import ada.tech.quero.ser.dev.domain.dto.exception.NotFoundException;
import ada.tech.quero.ser.dev.domain.dto.mappers.ProfessorMapper;
import ada.tech.quero.ser.dev.domain.dto.v1.ProfessorDto;
import ada.tech.quero.ser.dev.repositories.ProfessorRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ProfessorServicoBD implements IProfessorService {
    private  ProfessorRepository repositorio;

    public ProfessorServicoBD(ProfessorRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public ProfessorDto criarProfessor(ProfessorDto pedido) {
        Professor p = ProfessorMapper.toEntity(pedido);

        return ProfessorMapper.toDto(repositorio.save(p));

    }

    @Override
    public List<ProfessorDto> listarProfessores() {

        return repositorio.findAll().stream().map(ProfessorMapper::toDto).toList();
    }

    @Override
    public ProfessorDto buscarProfessor(int id) throws NotFoundException {
        return ProfessorMapper.toDto(buscarProfessorPorId(id));


    }

    @Override
    public ProfessorDto atualizarProfessor(int id, ProfessorDto pedido) throws NotFoundException {
        final Professor p = buscarProfessorPorId(id);
        p.setCpf(pedido.getCpf());
        p.setNome(pedido.getNome());
        p.setEmail(pedido.getEmail());
        return ProfessorMapper.toDto(repositorio.save(p));
    }
    @Override
    public void removerProfessor(int id) throws NotFoundException {
        final Professor p = buscarProfessorPorId(id);
        repositorio.delete(p);
        repositorio.deleteById(id);
    }


    private Professor buscarProfessorPorId(int id) throws NotFoundException {
        return repositorio.findById(id).orElseThrow(() -> new NotFoundException(Professor.class, String.valueOf(id)));
    }


    @Override
    public ProfessorDto buscarPorCpf(String cpf) throws NotFoundException {
        return ProfessorMapper.toDto(repositorio.findByCpf(cpf).orElseThrow(() -> new NotFoundException(Professor.class, cpf)));
    }

}

