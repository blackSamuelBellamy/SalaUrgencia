package cl.awakelab.secondsprint.restcontroller;

import cl.awakelab.secondsprint.entity.Medico;
import cl.awakelab.secondsprint.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medico")
@CrossOrigin(origins = "*")
public class MedicoRestController {
    @Autowired
    IMedicoService objMedicoService;

    @PostMapping
    public Medico crearMedico(@RequestBody Medico medico){
        return objMedicoService.crearMedico(medico);
    }

    @PutMapping("/{id}")
    public Medico actualizarMedico(@PathVariable int id, Medico medico){
        return objMedicoService.actualizarMedico(id, medico);
    }

    @GetMapping
    public List<Medico> listarMedicos(){return objMedicoService.listarMedicos();}

    @GetMapping("/{id}")
    public Medico buscarMedico(@PathVariable int id){
        return objMedicoService.buscarMedico(id);
    }

    @GetMapping("/visita/{id}")
    public Medico buscarMedicoVisita(@PathVariable int id){
        return objMedicoService.buscarMedicoVisita(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarMedico(@PathVariable int id){objMedicoService.eliminarMedico(id);}

    @DeleteMapping
    public void eliminarMedico2(@RequestBody Medico medico){objMedicoService.eliminarMedico2(medico);}
}
