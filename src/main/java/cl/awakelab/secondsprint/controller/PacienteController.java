package cl.awakelab.secondsprint.controller;

import cl.awakelab.secondsprint.entity.Medico;
import cl.awakelab.secondsprint.entity.Paciente;
import cl.awakelab.secondsprint.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    IPacienteService objPacienteService;

    @GetMapping("/listar")
    public String listarPacientes(Model model){
        List<Paciente> listaPacientes = objPacienteService.listarPacientes();
        model.addAttribute("listaPacientes", listaPacientes);
        return "templateListaPacientes";
    }

    @GetMapping("/crear")
    public String formCrearPaciente(){
        return "templateCrearPaciente";
    }

    @PostMapping("/crear")
    public String crearPaciente(@ModelAttribute Paciente paciente){
        objPacienteService.crearPaciente(paciente);
        return "redirect:/paciente/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarPaciente(@PathVariable Integer id){
        objPacienteService.eliminarPaciente(id);
        return "redirect:/paciente/listar";
    }
}
