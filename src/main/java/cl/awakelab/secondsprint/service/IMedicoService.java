package cl.awakelab.secondsprint.service;

import cl.awakelab.secondsprint.entity.Medico;

import java.util.List;

public interface IMedicoService {
    public Medico crearMedico(Medico medicoACrear);
    public Medico actualizarMedico(int id, Medico medico);
    public List<Medico> listarMedicos();
    public Medico buscarMedico(int id);
    public void eliminarMedico(int id);
    public void eliminarMedico2(Medico medico);
}
