package controller;
import java.util.List;

import dao.ServicoDAO;
import model.Servico;

public class ServicoController {
    private ServicoDAO servicoDAO;

    public ServicoController(ServicoDAO servicoDAO) {
        this.servicoDAO = servicoDAO;
    }

    public void adicionarServico(Servico servico) {
        servicoDAO.adicionarServico(servico);
    }

    public void atualizarServico(Servico servico) {
        servicoDAO.atualizarServico(servico);
    }

    public void removerServico(int id) {
        servicoDAO.removerServico(id);
    }

    public Servico buscarServico(int id) {
        return servicoDAO.buscarServico(id);
    }

    public List<Servico> listarServicos() {
        return servicoDAO.listarServicos();
    }
}
