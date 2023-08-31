package cl.awakelab.secondsprint.service.serviceimpl;

import cl.awakelab.secondsprint.entity.Medico;
import cl.awakelab.secondsprint.repository.IMedicoRepository;
import cl.awakelab.secondsprint.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("medicoServiceImpl")
public class MedicoServiceImpl implements IMedicoService {
    @Autowired
    IMedicoRepository objMedicoRepo;
    @Override
    public Medico crearMedico(Medico medicoACrear) {
        Medico medico = new Medico();
        medico = objMedicoRepo.save(medicoACrear);
        return medico;
    }

    @Override
    public Medico actualizarMedico(int id, Medico medicoActualizar) {
        Medico medicoEncontrado = objMedicoRepo.findById(id).orElse(null);
        medicoEncontrado.setNombres(medicoActualizar.getNombres());
        medicoEncontrado.setApellido1(medicoActualizar.getApellido1());
        medicoEncontrado.setApellido2(medicoActualizar.getApellido2());
        medicoEncontrado.setVisita(medicoActualizar.getVisita());
        return objMedicoRepo.save(medicoEncontrado);
    }

    @Override
    public List<Medico> listarMedicos() {
        List<Medico> listaDoctores = new ArrayList<>();
        listaDoctores = objMedicoRepo.findAll();
        return listaDoctores;
    }

    @Override
    public Medico buscarMedico(int id) {
        return objMedicoRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarMedico(int id) {
        objMedicoRepo.deleteById(id);

    }
    @Override
    public void eliminarMedico2(Medico medico) {
        objMedicoRepo.delete(medico);
    }
}
