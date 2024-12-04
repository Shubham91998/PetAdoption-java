package dao;

import java.util.List;

import model.Pet;

public interface PetDAO {
    void addPet(Pet pet);
    Pet getPetById(int petId);
    List<Pet> getAllPets();
    void updatePet(Pet pet);
    void deletePet(int petId);
}
