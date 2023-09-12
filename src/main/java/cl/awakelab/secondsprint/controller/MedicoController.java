package cl.awakelab.secondsprint.controller;

import cl.awakelab.secondsprint.entity.Medico;
import cl.awakelab.secondsprint.entity.Visita;
import cl.awakelab.secondsprint.service.IMedicoService;
import cl.awakelab.secondsprint.service.IVisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    IMedicoService objMedicoService;


    @GetMapping("/listar")
    public String listarMedicos(Model model){
        List<Medico> listaMedicos = objMedicoService.listarMedicos();
        model.addAttribute("listaMedicos", listaMedicos);
        return "templateMedicos";
    }

    @GetMapping("/crear")
    public String formCrearMedico(){
        return "templateCrearMedico";
    }

    @PostMapping ("/crear")
    public String crearMedico(@ModelAttribute Medico medico){
        objMedicoService.crearMedico(medico);
        return "redirect:/medico/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarMedico(@PathVariable Integer id){
        objMedicoService.eliminarMedico(id);
        return "redirect:/medico/listar";
    }
}
