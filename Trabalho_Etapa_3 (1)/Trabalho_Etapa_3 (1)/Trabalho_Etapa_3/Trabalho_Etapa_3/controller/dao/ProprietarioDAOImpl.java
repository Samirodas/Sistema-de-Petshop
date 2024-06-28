package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Proprietario;

public class ProprietarioDAOImpl implements ProprietarioDAO {
    private Connection connection;

    public ProprietarioDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionarProprietario(Proprietario proprietario) {
        String sql = "INSERT INTO Proprietario (nome, endereco, telefone, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, proprietario.getNome());
            stmt.setString(2, proprietario.getEndereco());
            stmt.setString(3, proprietario.getTelefone());
            stmt.setString(4, proprietario.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarProprietario(Proprietario proprietario) {
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, proprietario.getNome());
            stmt.setString(2, proprietario.getEndereco());
            stmt.setString(3, proprietario.getTelefone());
            stmt.setString(4, proprietario.getEmail());
            stmt.setInt(5, proprietario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerProprietario(int id) {
        String sql = "DELETE FROM Proprietario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Proprietario buscarProprietario(int id) {
        String sql = "SELECT * FROM Proprietario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Proprietario proprietario = new Proprietario();
                proprietario.setId(rs.getInt("id"));
                proprietario.setNome(rs.getString("nome"));
                proprietario.setEndereco(rs.getString("endereco"));
                proprietario.setTelefone(rs.getString("telefone"));
                proprietario.setEmail(rs.getString("email"));
                return proprietario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Proprietario> listarProprietarios() {
        List<Proprietario> proprietarios = new ArrayList<>();
        String sql = "SELECT * FROM Proprietario";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Proprietario proprietario = new Proprietario();
                proprietario.setId(rs.getInt("id"));
                proprietario.setNome(rs.getString("nome"));
                proprietario.setEndereco(rs.getString("endereco"));
                proprietario.setTelefone(rs.getString("telefone"));
                proprietario.setEmail(rs.getString("email"));
                proprietarios.add(proprietario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proprietarios;
    }

}
