package cl.awakelab.secondsprint.service.serviceimpl;

import cl.awakelab.secondsprint.entity.Paciente;
import cl.awakelab.secondsprint.repository.IPacienteRepository;
import cl.awakelab.secondsprint.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("pacienteServiceImpl")
public class PacienteServiceImpl implements IPacienteService {
    @Autowired
    IPacienteRepository objPacienteRepo;
    @Override
    public Paciente crearPaciente(Paciente pacienteACrear) {
        Paciente paciente = new Paciente();
        paciente = objPacienteRepo.save(pacienteACrear);
        return paciente;
    }

    @Override
    public Paciente actualizarPaciente(int id) {
        return null;
    }

    @Override
    public List<Paciente> listarPacientes() {
        List<Paciente> listaPacientes = new ArrayList<>();
        listaPacientes = objPacienteRepo.findAll();
        return listaPacientes;
    }

    @Override
    public Paciente buscarPaciente(int id) {
        return null;
    }

    @Override
    public void eliminarPaciente(int id) {

    }
}
