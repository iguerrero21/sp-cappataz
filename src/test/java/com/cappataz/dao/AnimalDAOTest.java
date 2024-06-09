package test.java.com.cappataz.dao;

import static org.junit.Assert.*;
import org.junit.Test;

import main.java.com.cappataz.dao.AnimalDAO;
import main.java.com.cappataz.modelo.Animal;

import java.sql.Date;
import java.util.List;

public class AnimalDAOTest {

    @Test
    public void testSaveAnimal() {
        AnimalDAO animalDAO = new AnimalDAO();
        Animal animal = new Animal(0, "TAG123", "RFID123", "Bovino", 
            "Hereford", new Date(System.currentTimeMillis()), 'F', false, 1, 1, 1);
        animalDAO.saveAnimal(animal);

        List<Animal> animals = animalDAO.getAllAnimals();
        assertFalse(animals.isEmpty());
    }

    // @Test
    // public void testGetAnimalById() {
    //     AnimalDAO animalDAO = new AnimalDAO();
    //     Animal animal = animalDAO.getAnimalById(1);
    //     assertNotNull(animal);
    // }
}
