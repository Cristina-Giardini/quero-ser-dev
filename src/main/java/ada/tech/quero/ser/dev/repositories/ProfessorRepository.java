package ada.tech.quero.ser.dev.repositories;

import ada.tech.quero.ser.dev.domain.dto.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    Optional<Professor> findByCpf(String cpf);

    boolean existsByCpf(@Param("cpf") String cpf);



}
