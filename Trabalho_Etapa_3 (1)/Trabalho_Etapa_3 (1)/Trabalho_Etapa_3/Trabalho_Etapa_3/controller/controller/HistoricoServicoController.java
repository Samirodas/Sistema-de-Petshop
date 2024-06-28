package controller;
import java.util.Date;
import java.util.List;

import dao.HistoricoServicoDAO;
import model.HistoricoServico;

public class HistoricoServicoController {
    private HistoricoServicoDAO historicoServicoDAO;

    public HistoricoServicoController(HistoricoServicoDAO historicoServicoDAO) {
        this.historicoServicoDAO = historicoServicoDAO;
    }

    public void adicionarHistoricoServico(HistoricoServico historicoServico) {
        historicoServicoDAO.adicionarHistoricoServico(historicoServico);
    }

    public void atualizarHistoricoServico(HistoricoServico historicoServico) {
        historicoServicoDAO.atualizarHistoricoServico(historicoServico);
    }

    public void removerHistoricoServico(int id) {
        historicoServicoDAO.removerHistoricoServico(id);
    }

    public HistoricoServico buscarHistoricoServico(int id) {
        return historicoServicoDAO.buscarHistoricoServico(id);
    }

    public List<HistoricoServico> listarHistoricoServicos() {
        return historicoServicoDAO.listarHistoricoServicos();
    }

    public List<HistoricoServico> listarHistoricoServicosPorAnimal(int animalId) {
        return historicoServicoDAO.listarHistoricoServicosPorAnimal(animalId);
    }

    public List<HistoricoServico> listarHistoricoServicosPorPeriodo(int animalId, Date inicio, Date fim) {
        return historicoServicoDAO.listarHistoricoServicosPorPeriodo(animalId, inicio, fim);
    }
}
