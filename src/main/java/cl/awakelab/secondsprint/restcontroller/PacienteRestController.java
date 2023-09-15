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

    @PutMapping("/{id}")
    public Paciente actualizarPaciente(@RequestBody Paciente paciente) {
        return objPacienteService.actualizarPaciente(paciente);
    }

    @GetMapping
    public List<Paciente> listarPacientes(){return objPacienteService.listarPacientes();}

    @GetMapping("/{id}")
    public Paciente buscarPacienteId(@PathVariable int id){
        return objPacienteService.buscarPaciente(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable int id){objPacienteService.eliminarPaciente(id);}

    @DeleteMapping
    public void eliminarPaciente2(@RequestBody Paciente paciente){objPacienteService.elminarPaciente2(paciente);}
}
