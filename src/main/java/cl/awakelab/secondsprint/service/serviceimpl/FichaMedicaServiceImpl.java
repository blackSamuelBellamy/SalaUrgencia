package cl.awakelab.secondsprint.service.serviceimpl;

import cl.awakelab.secondsprint.entity.FichaMedica;
import cl.awakelab.secondsprint.repository.IFichaMedicaRepository;
import cl.awakelab.secondsprint.service.IFichaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fichaMedicaServiceImpl")
public class FichaMedicaServiceImpl implements IFichaMedicaService {
    @Autowired
    IFichaMedicaRepository objFichaMedicaRepo;
    @Override
    public FichaMedica crearFichaMedica(FichaMedica fichaMedicaACrear) {
        FichaMedica fichaMedica = new FichaMedica();
        fichaMedica = objFichaMedicaRepo.save(fichaMedicaACrear);
        return fichaMedica;
    }

    @Override
    public FichaMedica actualizarFichaMedica(int id) {
        return null;
    }

    @Override
    public List<FichaMedica> listarFichasMedicas() {
        List<FichaMedica> fichasMedicas = new ArrayList<>();
        fichasMedicas = objFichaMedicaRepo.findAll();
        return fichasMedicas;
    }

    @Override
    public FichaMedica buscarFichaMedica(int id) {
        return null;
    }

    @Override
    public void eliminarFichaMedica(int id) {

    }
}
