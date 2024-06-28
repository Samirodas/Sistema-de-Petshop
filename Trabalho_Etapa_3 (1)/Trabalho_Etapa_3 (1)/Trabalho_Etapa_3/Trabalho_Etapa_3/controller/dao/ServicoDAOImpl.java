package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Servico;

public class ServicoDAOImpl implements ServicoDAO {
    private Connection connection;

    public ServicoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionarServico(Servico servico) {
        String sql = "INSERT INTO Servico (nome, descricao, preco) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, servico.getNome());
            stmt.setString(2, servico.getDescricao());
            stmt.setDouble(3, servico.getPreco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarServico(Servico servico) {
        String sql = "UPDATE Servico SET nome = ?, descricao = ?, preco = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, servico.getNome());
            stmt.setString(2, servico.getDescricao());
            stmt.setDouble(3, servico.getPreco());
            stmt.setInt(4, servico.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerServico(int id) {
        String sql = "DELETE FROM Servico WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Servico buscarServico(int id) {
        String sql = "SELECT * FROM Servico WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Servico servico = new Servico();
                servico.setId(rs.getInt("id"));
                servico.setNome(rs.getString("nome"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setPreco(rs.getDouble("preco"));
                return servico;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Servico> listarServicos() {
        List<Servico> servicos = new ArrayList<>();
        String sql = "SELECT * FROM Servico";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Servico servico = new Servico();
                servico.setId(rs.getInt("id"));
                servico.setNome(rs.getString("nome"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setPreco(rs.getDouble("preco"));
                servicos.add(servico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servicos;
    }

}
