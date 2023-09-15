package cl.awakelab.secondsprint.restcontroller;

import cl.awakelab.secondsprint.entity.FichaMedica;
import cl.awakelab.secondsprint.service.IFichaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fichamedica")
@CrossOrigin(origins = "*")
public class FichaMedicaRestController {
    @Autowired
    IFichaMedicaService objFichaMedicaService;

    @PostMapping
    public FichaMedica crearFichaMedica(@RequestBody FichaMedica fichaMedica){
        return objFichaMedicaService.crearFichaMedica(fichaMedica);
    }

    @PutMapping("/{id}")
    public FichaMedica actualizarFichaMedica(@PathVariable int id, @RequestBody FichaMedica fichaMedica){
        return objFichaMedicaService.actualizarFichaMedica(id, fichaMedica);
    }

    @GetMapping
    public List<FichaMedica> listarFichasMedicas(){return objFichaMedicaService.listarFichasMedicas();}

    @GetMapping("/{id}")
    public FichaMedica buscarFichaMedica(@PathVariable int id){return objFichaMedicaService.buscarFichaMedica(id);}

    @DeleteMapping("/{id}")
    public void eliminarFichaMedica(@PathVariable int id){objFichaMedicaService.eliminarFichaMedica(id);}

    @DeleteMapping
    public void eliminarFichaMedica(@RequestBody FichaMedica fichaMedica){
        objFichaMedicaService.eliminarfichaMedica2(fichaMedica);}
}
