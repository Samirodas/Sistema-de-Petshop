package dao;
import java.util.List;

import model.Servico;

public interface ServicoDAO {
    void adicionarServico(Servico servico);
    void atualizarServico(Servico servico);
    void removerServico(int id);
    Servico buscarServico(int id);
    List<Servico> listarServicos();
}
