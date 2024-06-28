package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Animal;
import model.HistoricoServico;
import model.Servico;

public class HistoricoServicoDAOImpl implements HistoricoServicoDAO {
    private Connection connection;

    public HistoricoServicoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionarHistoricoServico(HistoricoServico historicoServico) {
        String sql = "INSERT INTO HistoricoServico (data, servico_id, animal_id, valor, observacoes) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(historicoServico.getData().getTime()));
            stmt.setInt(2, historicoServico.getServico().getId());
            stmt.setInt(3, historicoServico.getAnimal().getId());
            stmt.setDouble(4, historicoServico.getValor());
            stmt.setString(5, historicoServico.getObservacoes());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarHistoricoServico(HistoricoServico historicoServico) {
        String sql = "UPDATE HistoricoServico SET data = ?, servico_id = ?, animal_id = ?, valor = ?, observacoes = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(historicoServico.getData().getTime()));
            stmt.setInt(2, historicoServico.getServico().getId());
            stmt.setInt(3, historicoServico.getAnimal().getId());
            stmt.setDouble(4, historicoServico.getValor());
            stmt.setString(5, historicoServico.getObservacoes());
            stmt.setInt(6, historicoServico.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerHistoricoServico(int id) {
        String sql = "DELETE FROM HistoricoServico WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HistoricoServico buscarHistoricoServico(int id) {
        String sql = "SELECT * FROM HistoricoServico WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                HistoricoServico historicoServico = new HistoricoServico();
                historicoServico.setId(rs.getInt("id"));
                historicoServico.setData(rs.getDate("data"));
                historicoServico.setValor(rs.getDouble("valor"));
                historicoServico.setObservacoes(rs.getString("observacoes"));

                Servico servico = new ServicoDAOImpl(connection).buscarServico(rs.getInt("servico_id"));
                historicoServico.setServico(servico);

                Animal animal = new AnimalDAOImpl(connection).buscarAnimal(rs.getInt("animal_id"));
                historicoServico.setAnimal(animal);

                return historicoServico;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HistoricoServico> listarHistoricoServicos() {
        List<HistoricoServico> historicoServicos = new ArrayList<>();
        String sql = "SELECT * FROM HistoricoServico";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HistoricoServico historicoServico = new HistoricoServico();
                historicoServico.setId(rs.getInt("id"));
                historicoServico.setData(rs.getDate("data"));
                historicoServico.setValor(rs.getDouble("valor"));
                historicoServico.setObservacoes(rs.getString("observacoes"));

                Servico servico = new ServicoDAOImpl(connection).buscarServico(rs.getInt("servico_id"));
                historicoServico.setServico(servico);

                Animal animal = new AnimalDAOImpl(connection).buscarAnimal(rs.getInt("animal_id"));
                historicoServico.setAnimal(animal);

                historicoServicos.add(historicoServico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historicoServicos;
    }

    @Override
    public List<HistoricoServico> listarHistoricoServicosPorAnimal(int animalId) {
        List<HistoricoServico> historicoServicos = new ArrayList<>();
        String sql = "SELECT * FROM HistoricoServico WHERE animal_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, animalId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HistoricoServico historicoServico = new HistoricoServico();
                historicoServico.setId(rs.getInt("id"));
                historicoServico.setData(rs.getDate("data"));
                historicoServico.setValor(rs.getDouble("valor"));
                historicoServico.setObservacoes(rs.getString("observacoes"));

                Servico servico = new ServicoDAOImpl(connection).buscarServico(rs.getInt("servico_id"));
                historicoServico.setServico(servico);

                Animal animal = new AnimalDAOImpl(connection).buscarAnimal(rs.getInt("animal_id"));
                historicoServico.setAnimal(animal);

                historicoServicos.add(historicoServico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historicoServicos;
    }

    @Override
    public List<HistoricoServico> listarHistoricoServicosPorPeriodo(int animalId, Date inicio, Date fim) {
        List<HistoricoServico> historicoServicos = new ArrayList<>();
        String sql = "SELECT * FROM HistoricoServico WHERE animal_id = ? AND data BETWEEN ? AND ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, animalId);
            stmt.setDate(2, new java.sql.Date(inicio.getTime()));
            stmt.setDate(3, new java.sql.Date(fim.getTime()));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HistoricoServico historicoServico = new HistoricoServico();
                historicoServico.setId(rs.getInt("id"));
                historicoServico.setData(rs.getDate("data"));
                historicoServico.setValor(rs.getDouble("valor"));
                historicoServico.setObservacoes(rs.getString("observacoes"));

                Servico servico = new ServicoDAOImpl(connection).buscarServico(rs.getInt("servico_id"));
                historicoServico.setServico(servico);

                Animal animal = new AnimalDAOImpl(connection).buscarAnimal(rs.getInt("animal_id"));
                historicoServico.setAnimal(animal);

                historicoServicos.add(historicoServico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historicoServicos;
    }
}
