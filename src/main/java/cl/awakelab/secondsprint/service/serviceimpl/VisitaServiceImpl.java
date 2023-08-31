package cl.awakelab.secondsprint.service.serviceimpl;

import cl.awakelab.secondsprint.entity.Visita;
import cl.awakelab.secondsprint.repository.IVisitaRepository;
import cl.awakelab.secondsprint.service.IVisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("visitaServiceImpl")
public class VisitaServiceImpl implements IVisitaService {
    @Autowired
    IVisitaRepository objVisitaRepo;
    @Override
    public Visita crearVisita(Visita visitaACrear) {
        Visita visita = new Visita();
        visita = objVisitaRepo.save(visitaACrear);
        return visita;
    }

    @Override
    public Visita actualizarVisita(int id, Visita visitaActualizar) {
        Visita visitaEncontrada = objVisitaRepo.findById(id).orElse(null);
        visitaEncontrada.setFichaMedica(visitaActualizar.getFichaMedica());
        visitaEncontrada.setMedico(visitaActualizar.getMedico());
        visitaEncontrada.setObservaciones(visitaActualizar.getObservaciones());
        return objVisitaRepo.save(visitaEncontrada);
    }

    @Override
    public List<Visita> listarVisitas() {
        List<Visita> listaVisitas = new ArrayList<>();
        listaVisitas = objVisitaRepo.findAll();
        return listaVisitas;
    }

    @Override
    public Visita buscarVisita(int id) {
        return objVisitaRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarVisita(int id) {
        objVisitaRepo.deleteById(id);
    }

    @Override
    public void elminarVisita2(Visita visita) {
        objVisitaRepo.delete(visita);
    }
}
