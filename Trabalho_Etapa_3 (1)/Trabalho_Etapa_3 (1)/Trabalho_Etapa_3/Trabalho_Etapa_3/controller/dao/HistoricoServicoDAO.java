package dao;
import java.util.Date;
import java.util.List;

import model.HistoricoServico;

public interface HistoricoServicoDAO {
    void adicionarHistoricoServico(HistoricoServico historicoServico);
    void atualizarHistoricoServico(HistoricoServico historicoServico);
    void removerHistoricoServico(int id);
    HistoricoServico buscarHistoricoServico(int id);
    List<HistoricoServico> listarHistoricoServicos();
    List<HistoricoServico> listarHistoricoServicosPorAnimal(int animalId);
    List<HistoricoServico> listarHistoricoServicosPorPeriodo(int animalId, Date inicio, Date fim);
}
