package cl.awakelab.secondsprint.restcontroller;

import cl.awakelab.secondsprint.entity.Paciente;
import cl.awakelab.secondsprint.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paciente")
public class PacienteRestController {
    @Autowired
    IPacienteService objPacienteService;

    @PostMapping
    public Paciente crearPaciente(@RequestBody Paciente paciente){
        return objPacienteService.crearPaciente(paciente);
    }

    @PostMapping
    public Paciente actualizarPaciente(@RequestBody int id, Paciente paciente) {
        return objPacienteService.actualizarPaciente(id, paciente);
    }

    @GetMapping
    public List<Paciente> listarPacientes(){return objPacienteService.listarPacientes();}

    @PostMapping
    public Paciente buscarPacienteId(@RequestBody int id){
        return objPacienteService.buscarPaciente(id);
    }

    @PostMapping
    public void eliminarPaciente(@RequestBody int id){objPacienteService.eliminarPaciente(id);}

    @PostMapping
    public void eliminarPaciente2(@RequestBody Paciente paciente){objPacienteService.elminarPaciente2(paciente);}
}
