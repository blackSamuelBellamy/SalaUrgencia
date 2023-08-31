package cl.awakelab.secondsprint.service;

import cl.awakelab.secondsprint.entity.Visita;

import java.util.List;

public interface IVisitaService {
    public Visita crearVisita(Visita visitaACrear);
    public Visita actualizarVisita(int id, Visita visita);
    public List<Visita> listarVisitas();
    public Visita buscarVisita(int id);
    public void eliminarVisita(int id);
    public void elminarVisita2(Visita visita);
}
