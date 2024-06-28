package controller;
import java.util.List;

import dao.ProprietarioDAO;
import model.Proprietario;

public class ProprietarioController {
    private ProprietarioDAO proprietarioDAO;

    public ProprietarioController(ProprietarioDAO proprietarioDAO) {
        this.proprietarioDAO = proprietarioDAO;
    }

    public void adicionarProprietario(Proprietario proprietario) {
        proprietarioDAO.adicionarProprietario(proprietario);
    }

    public void atualizarProprietario(Proprietario proprietario) {
        proprietarioDAO.atualizarProprietario(proprietario);
    }

    public void removerProprietario(int id) {
        proprietarioDAO.removerProprietario(id);
    }

    public Proprietario buscarProprietario(int id) {
        return proprietarioDAO.buscarProprietario(id);
    }

    public List<Proprietario> listarProprietarios() {
        return proprietarioDAO.listarProprietarios();
    }
}
