package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Animal;

public class AnimalDAOImpl implements AnimalDAO {
    private Connection connection;

    public AnimalDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionarAnimal(Animal animal) {
        String sql = "INSERT INTO Animal (nome, especie, raca, idade, sexo, peso, foto, proprietario_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setInt(4, animal.getIdade());
            stmt.setString(5, animal.getSexo());
            stmt.setDouble(6, animal.getPeso());
            stmt.setString(7, animal.getFoto());
            stmt.setInt(8, animal.getProprietarioId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarAnimal(Animal animal) {
        String sql = "UPDATE Animal SET nome = ?, especie = ?, raca = ?, idade = ?, sexo = ?, peso = ?, foto = ?, proprietario_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setInt(4, animal.getIdade());
            stmt.setString(5, animal.getSexo());
            stmt.setDouble(6, animal.getPeso());
            stmt.setString(7, animal.getFoto());
            stmt.setInt(8, animal.getProprietarioId());
            stmt.setInt(9, animal.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerAnimal(int id) {
        String sql = "DELETE FROM Animal WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Animal buscarAnimal(int id) {
        String sql = "SELECT * FROM Animal WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getInt("id"));
                animal.setNome(rs.getString("nome"));
                animal.setEspecie(rs.getString("especie"));
                animal.setRaca(rs.getString("raca"));
                animal.setIdade(rs.getInt("idade"));
                animal.setSexo(rs.getString("sexo"));
                animal.setPeso(rs.getDouble("peso"));
                animal.setFoto(rs.getString("foto"));
                animal.setProprietarioId(rs.getInt("proprietario_id"));
                return animal;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Animal> listarAnimais() {
        List<Animal> animais = new ArrayList<>();
        String sql = "SELECT * FROM Animal";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getInt("id"));
                animal.setNome(rs.getString("nome"));
                animal.setEspecie(rs.getString("especie"));
                animal.setRaca(rs.getString("raca"));
                animal.setIdade(rs.getInt("idade"));
                animal.setSexo(rs.getString("sexo"));
                animal.setPeso(rs.getDouble("peso"));
                animal.setFoto(rs.getString("foto"));
                animal.setProprietarioId(rs.getInt("proprietario_id"));
                animais.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animais;
    }
}
