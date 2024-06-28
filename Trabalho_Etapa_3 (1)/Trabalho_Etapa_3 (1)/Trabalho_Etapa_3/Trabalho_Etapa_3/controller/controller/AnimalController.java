package controller;
import java.util.List;

import dao.AnimalDAO;
import model.Animal;

public class AnimalController {
    private AnimalDAO animalDAO;

    public AnimalController(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    public void adicionarAnimal(Animal animal) {
        animalDAO.adicionarAnimal(animal);
    }

    public void atualizarAnimal(Animal animal) {
        animalDAO.atualizarAnimal(animal);
    }

    public void removerAnimal(int id) {
        animalDAO.removerAnimal(id);
    }

    public Animal buscarAnimal(int id) {
        return animalDAO.buscarAnimal(id);
    }

    public List<Animal> listarAnimais() {
        return animalDAO.listarAnimais();
    }
}
