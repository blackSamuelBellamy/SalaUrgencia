package cl.awakelab.secondsprint.service;

import cl.awakelab.secondsprint.entity.FichaMedica;

import java.util.List;

public interface IFichaMedicaService {
    public FichaMedica crearFichaMedica(FichaMedica fichaMedicaACrear);
    public FichaMedica actualizarFichaMedica(int id);
    public List<FichaMedica> listarFichasMedicas();
    public FichaMedica buscarFichaMedica(int id);
    public void eliminarFichaMedica(int id);
}
