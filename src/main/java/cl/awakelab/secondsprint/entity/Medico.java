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


    @OneToMany(mappedBy = "medico")
    private List<Visita> listaVisitas;

}
