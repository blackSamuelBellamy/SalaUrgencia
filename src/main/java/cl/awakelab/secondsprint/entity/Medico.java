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
@Table(name = "medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 75)
    private String nombres;

    @Column(nullable = false, length = 30)
    private String apellido1;

    @Column(nullable = false, length = 30)
    private String apellido2;

    @Column(nullable = false)
    private String especialidad;

    @OneToOne(mappedBy = "medico")
    private Visita visita;

    @ManyToMany
    @JoinTable(name = "medico_paciente",
    joinColumns = @JoinColumn(name = "FK_Medico", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "FK_Paciente", nullable = false))
    private List<Paciente> pacientes;
}
