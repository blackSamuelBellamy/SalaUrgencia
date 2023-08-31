package cl.awakelab.secondsprint.service;

import cl.awakelab.secondsprint.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    public Paciente crearPaciente(Paciente pacienteACrear);
    public Paciente actualizarPaciente(int id, Paciente paciente);
    public List<Paciente> listarPacientes();
    public Paciente buscarPaciente(int id);
    public void eliminarPaciente(int id);
    public void elminarPaciente2(Paciente paciente);

}
