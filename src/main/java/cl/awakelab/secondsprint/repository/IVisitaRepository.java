package cl.awakelab.secondsprint.repository;

import cl.awakelab.secondsprint.entity.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVisitaRepository extends JpaRepository<Visita, Integer> {
}
