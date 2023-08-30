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
    public Medico actualizarMedico(int id) {
        return null;
    }

    @Override
    public List<Medico> listarMedicos() {
        List<Medico> listaDoctores = new ArrayList<>();
        listaDoctores = objMedicoRepo.findAll();
        return listaDoctores;
    }

    @Override
    public Medico buscarMedico(int id) {
        return null;
    }

    @Override
    public void eliminarMedico(int id) {

    }
}
