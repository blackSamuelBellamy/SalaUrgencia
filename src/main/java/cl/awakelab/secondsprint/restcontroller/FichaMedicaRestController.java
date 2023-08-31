package cl.awakelab.secondsprint.restcontroller;

import cl.awakelab.secondsprint.entity.FichaMedica;
import cl.awakelab.secondsprint.service.IFichaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fichamedica")
public class FichaMedicaRestController {
    @Autowired
    IFichaMedicaService objFichaMedicaService;

    @PostMapping
    public FichaMedica crearFichaMedica(@RequestBody FichaMedica fichaMedica){
        return objFichaMedicaService.crearFichaMedica(fichaMedica);
    }

    @PostMapping
    public FichaMedica actualizarFichaMedica(@RequestBody int id, FichaMedica fichaMedica){
        return objFichaMedicaService.actualizarFichaMedica(id, fichaMedica);
    }

    @GetMapping
    public List<FichaMedica> listarFichasMedicas(){return objFichaMedicaService.listarFichasMedicas();}

    @PostMapping
    public FichaMedica buscarFichaMedica(@RequestBody int id){return objFichaMedicaService.buscarFichaMedica(id);}

    @PostMapping
    public void eliminarFichaMedica(@RequestBody int id){objFichaMedicaService.eliminarFichaMedica(id);}

    @PostMapping
    public void eliminarFichaMedica(@RequestBody FichaMedica fichaMedica){
        objFichaMedicaService.eliminarfichaMedica2(fichaMedica);}
}
