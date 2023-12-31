package cl.awakelab.secondsprint.controller;

import cl.awakelab.secondsprint.entity.FichaMedica;
import cl.awakelab.secondsprint.entity.Medico;
import cl.awakelab.secondsprint.entity.Visita;
import cl.awakelab.secondsprint.service.IFichaMedicaService;
import cl.awakelab.secondsprint.service.IMedicoService;
import cl.awakelab.secondsprint.service.IVisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/visita")
public class VisitaController {
    @Autowired
    IVisitaService objVisitaService;

    @Autowired
    IMedicoService objMedicoService;

    @Autowired
    IFichaMedicaService objFichaMedicaService;

    @GetMapping()
    public String visitas(){
        return "redirect:/visita/listar";
    }

    @GetMapping("/listar")
    public String listarVisitas(Model model){
        List<Visita> listaVisitas = objVisitaService.listarVisitas();
        model.addAttribute("visitas", listaVisitas);
        return "templateListarVisitas";
    }


    @GetMapping("/crearvisita")
    public String crearVisita(Model model){
        List<Medico> medicos = objMedicoService.listarMedicos();
        List<FichaMedica> fichasMedicas = objFichaMedicaService.listarFichasMedicas();
        model.addAttribute("medicos", medicos);
        model.addAttribute("fichasMedicas", fichasMedicas);
        return "templateCrearVisita";
    }

    @GetMapping("/editar/{id}")
    public String editarVisita(@PathVariable int id, Model model){
    Visita visita = objVisitaService.buscarVisita(id);
    List<FichaMedica> fichaMedica = objFichaMedicaService.listarFichasMedicas();
    List<Medico> medicos = objMedicoService.listarMedicos();
    model.addAttribute("visita", visita);
    model.addAttribute("medicos", medicos);
    model.addAttribute("fichas", fichaMedica);
    return "templateEditarVisitas";
    }

    @PostMapping("/editar")
    public String editarVisita(@ModelAttribute Visita visita){
        objVisitaService.actualizarVisita(visita.getId(), visita);
        return "redirect:/visita/listar";
    }

    @PostMapping("/crearvisita")
    public String crearVisita(@ModelAttribute Visita visita){
        objVisitaService.crearVisita(visita);
        return "redirect:/visita/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarVisita(@PathVariable int id){
        objVisitaService.eliminarVisita(id);
        return "redirect:/visita/listar";
    }
}
