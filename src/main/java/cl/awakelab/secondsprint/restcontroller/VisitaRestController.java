package cl.awakelab.secondsprint.restcontroller;

import cl.awakelab.secondsprint.entity.Visita;
import cl.awakelab.secondsprint.service.IVisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visita")
public class VisitaRestController {
    @Autowired
    IVisitaService objVisitaService;

    @PostMapping
    public Visita crearVisita(@RequestBody Visita visita){
        return objVisitaService.crearVisita(visita);
    }

    @PostMapping
    public Visita actualizarVisita(@RequestBody int id, Visita visita){
        return objVisitaService.actualizarVisita(id, visita);
    }

    @GetMapping
    public List<Visita> listarVisitas(){return objVisitaService.listarVisitas();}

    @PostMapping
    public Visita buscarVisitaId(@RequestBody int id){
        return objVisitaService.buscarVisita(id);
    }

    @PostMapping
    public void eliminarVisita(@RequestBody int id){
        objVisitaService.eliminarVisita(id);
    }

    @PostMapping
    public void eliminarVisita2(@RequestBody Visita visita){
        objVisitaService.elminarVisita2(visita);
    }
}
