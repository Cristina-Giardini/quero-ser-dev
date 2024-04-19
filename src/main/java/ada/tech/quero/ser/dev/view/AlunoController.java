package ada.tech.quero.ser.dev.view;


import ada.tech.quero.ser.dev.domain.dto.exception.NotFoundException;
import ada.tech.quero.ser.dev.domain.dto.v2.AlunoDto;
import ada.tech.quero.ser.dev.service.IAlunoService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Aluno")
public class AlunoController {
    private IAlunoService servico;


    @GetMapping
    public ResponseEntity<List<AlunoDto>> lerAlunos() {
        return ResponseEntity.ok(servico.listarAlunos());
    }

    @PostMapping
    public ResponseEntity<AlunoDto> criarAluno(
            @RequestBody @Valid AlunoDto pedido
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servico.criarAluno(pedido));

    }
    @PutMapping("/{id}")
    public ResponseEntity<AlunoDto> atualizarAluno(
            @PathVariable("id") int id,
            @RequestBody AlunoDto pedido
    ) throws NotFoundException {
        final AlunoDto p = servico.atualizarAluno(id, pedido);
        if (p == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(p);

    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> buscarAluno(
            @PathVariable("id") int id
    ) throws NotFoundException {
        return ResponseEntity.ok(servico.buscarAluno(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAluno(
            @PathVariable("id") int id
    )  throws NotFoundException {
        servico.removerAluno(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<AlunoDto> buscarPorCpf(@PathParam("cpf") String cpf) throws NotFoundException {
        return ResponseEntity.ok(servico.buscarPorCpf(cpf));
    }

}


