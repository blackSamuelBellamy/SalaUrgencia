package cl.awakelab.secondsprint.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ficha_medica")
public class FichaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "ficha")
    private Paciente paciente;

    @OneToMany(mappedBy = "fichaMedica")
    private List<Visita> visitas;


}
