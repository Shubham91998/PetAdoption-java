import java.util.List;

import model.Pet;
import dao.PetDAOImpl;
public class App {
    public static void main(String[] args) {
    	PetDAOImpl petDAO = new PetDAOImpl();

        // Create a new Pet
        Pet pet = new Pet();
        pet.setName("Buddy");
        pet.setSpecies("Dog");
        pet.setBreed("Golden Retriever");
        pet.setAge(3);
        pet.setGender("Male");
        pet.setDescription("Friendly and playful.");
        pet.setImageUrl("https://example.com/buddy.jpg");
        pet.setAdoptionStatus("Available");
        petDAO.addPet(pet);

        // Get all pets
        List<Pet> pets = petDAO.getAllPets();
        for (Pet p : pets) {
            System.out.println(p.getName() + " - " + p.getSpecies());
        }

        // Get a pet by ID
        Pet fetchedPet = petDAO.getPetById(1);
        System.out.println(fetchedPet.getName() + " is available for adoption.");

        // Update a pet
        pet.setName("Buddy Updated");
        petDAO.updatePet(pet);

        // Delete a pet
        petDAO.deletePet(2);
    }
}
