package service;

import java.util.List;

import model.Pet;
import dao.PetDAOImpl;

public class PetService {
    private PetDAOImpl petDAO;

    public PetService() {
        this.petDAO = new PetDAOImpl();  // Initialize DAO
    }

    // Add a new pet
    public void addPet(Pet pet) {
        petDAO.addPet(pet);
    }

    // Get pet by ID
    public Pet getPetById(int petId) {
        return petDAO.getPetById(petId);
    }

    // Get all pets
    public List<Pet> getAllPets() {
        return petDAO.getAllPets();
    }

    // Update pet details
    public void updatePet(Pet pet) {
        petDAO.updatePet(pet);
    }

    // Delete a pet by ID
    public void deletePet(int petId) {
        petDAO.deletePet(petId);
    }
}
