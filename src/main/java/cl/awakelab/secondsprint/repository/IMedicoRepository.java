package cl.awakelab.secondsprint.repository;

import cl.awakelab.secondsprint.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicoRepository extends JpaRepository<Medico, Integer> {
}
