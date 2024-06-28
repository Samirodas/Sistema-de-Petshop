package dao;
import java.util.List;

import model.Proprietario;

public interface ProprietarioDAO {
    void adicionarProprietario(Proprietario proprietario);
    void atualizarProprietario(Proprietario proprietario);
    void removerProprietario(int id);
    Proprietario buscarProprietario(int id);
    List<Proprietario> listarProprietarios();
}
