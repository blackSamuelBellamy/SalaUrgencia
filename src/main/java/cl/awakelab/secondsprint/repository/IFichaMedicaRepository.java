package cl.awakelab.secondsprint.repository;

import cl.awakelab.secondsprint.entity.FichaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFichaMedicaRepository extends JpaRepository<FichaMedica, Integer> {
}
