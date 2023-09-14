package cl.awakelab.secondsprint.controller;

import cl.awakelab.secondsprint.entity.FichaMedica;
import cl.awakelab.secondsprint.entity.Paciente;
import cl.awakelab.secondsprint.entity.Visita;
import cl.awakelab.secondsprint.service.IFichaMedicaService;
import cl.awakelab.secondsprint.service.IPacienteService;
import cl.awakelab.secondsprint.service.IVisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fichamedica")
public class FichaMedicaController {

    @Autowired
    IFichaMedicaService objFichaMedicaService;
    @Autowired
    IPacienteService objPacienteService;
    @Autowired
    IVisitaService objVistaService;

    @GetMapping()
    public String listarFichasMedicas(Model model){
        List<FichaMedica> listaFichas = objFichaMedicaService.listarFichasMedicas();
        model.addAttribute("listaFichasMedicas",listaFichas);
        return "templateListaFichas";
    }

    @GetMapping("/crear")
    public String formCrearFichaMedica(Model model){
        List<Paciente> listaPacientes = objPacienteService.listarPacientes();
        model.addAttribute("listaPacientes", listaPacientes);
        List<Visita> listaVisitas = objVistaService.listarVisitas();
        model.addAttribute("listaVisitas", listaVisitas);
        return "crearFichaMedica";
    }

    @PostMapping("/crear")
    public String crearFichaMedica(@ModelAttribute FichaMedica ficha){
        objFichaMedicaService.crearFichaMedica(ficha);
        return "redirect:/fichaMedica/listar";

    }

    @GetMapping("/buscar/{id}")
    public String buscarFichaMedica(@PathVariable Integer id, Model model){
        FichaMedica fichaEncontrada = objFichaMedicaService.buscarFichaMedica(id);
        model.addAttribute("fichaEncontrada", fichaEncontrada);
        return "templateFichaBusqueda";

    }

    @PostMapping("eliminar/{id}")
    public String eliminarFichaMedica(@PathVariable Integer id){
        objFichaMedicaService.eliminarFichaMedica(id);
        return "redirect:/listar";
    }

    @GetMapping("/actualizar/{id}")
    public String formActualizarFichaMedica(@PathVariable Integer id, Model model){
        FichaMedica fichaActualizar = objFichaMedicaService.buscarFichaMedica(id);
        model.addAttribute("fichaActualizar", fichaActualizar);
        return "actualizarFichaMedica";
    }

    @PostMapping("/actualizar")
    public String actualizarFichaMedica(@ModelAttribute FichaMedica ficha){
        Integer id = ficha.getId();
        objFichaMedicaService.actualizarFichaMedica(id, ficha);
        return "redirect:/buscar/{" + id + "}";

    }
}
