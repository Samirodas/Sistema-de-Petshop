package dao;
import java.util.List;

import model.Animal;

public interface AnimalDAO {
    void adicionarAnimal(Animal animal);
    void atualizarAnimal(Animal animal);
    void removerAnimal(int id);
    Animal buscarAnimal(int id);
    List<Animal> listarAnimais();
}
