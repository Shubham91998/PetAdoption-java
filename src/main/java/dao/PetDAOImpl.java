package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Pet;
import util.DBConnection;

public class PetDAOImpl implements PetDAO {

    private Connection connection;

    public PetDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public void addPet(Pet pet) {
        String sql = "INSERT INTO pets (name, species, breed, age, gender, description, image_url, adoption_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getSpecies());
            statement.setString(3, pet.getBreed());
            statement.setInt(4, pet.getAge());
            statement.setString(5, pet.getGender());
            statement.setString(6, pet.getDescription());
            statement.setString(7, pet.getImageUrl());
            statement.setString(8, pet.getAdoptionStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pet getPetById(int petId) {
        String sql = "SELECT * FROM pets WHERE pet_id = ?";
        Pet pet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, petId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                pet = new Pet();
                pet.setPetId(resultSet.getInt("pet_id"));
                pet.setName(resultSet.getString("name"));
                pet.setSpecies(resultSet.getString("species"));
                pet.setBreed(resultSet.getString("breed"));
                pet.setAge(resultSet.getInt("age"));
                pet.setGender(resultSet.getString("gender"));
                pet.setDescription(resultSet.getString("description"));
                pet.setImageUrl(resultSet.getString("image_url"));
                pet.setAdoptionStatus(resultSet.getString("adoption_status"));
                pet.setCreatedAt(resultSet.getTimestamp("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pet;
    }

    @Override
    public List<Pet> getAllPets() {
        String sql = "SELECT * FROM pets";
        List<Pet> pets = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Pet pet = new Pet();
                pet.setPetId(resultSet.getInt("pet_id"));
                pet.setName(resultSet.getString("name"));
                pet.setSpecies(resultSet.getString("species"));
                pet.setBreed(resultSet.getString("breed"));
                pet.setAge(resultSet.getInt("age"));
                pet.setGender(resultSet.getString("gender"));
                pet.setDescription(resultSet.getString("description"));
                pet.setImageUrl(resultSet.getString("image_url"));
                pet.setAdoptionStatus(resultSet.getString("adoption_status"));
                pet.setCreatedAt(resultSet.getTimestamp("created_at"));
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    @Override
    public void updatePet(Pet pet) {
        String sql = "UPDATE pets SET name = ?, species = ?, breed = ?, age = ?, gender = ?, description = ?, image_url = ?, adoption_status = ? WHERE pet_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getSpecies());
            statement.setString(3, pet.getBreed());
            statement.setInt(4, pet.getAge());
            statement.setString(5, pet.getGender());
            statement.setString(6, pet.getDescription());
            statement.setString(7, pet.getImageUrl());
            statement.setString(8, pet.getAdoptionStatus());
            statement.setInt(9, pet.getPetId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePet(int petId) {
        String sql = "DELETE FROM pets WHERE pet_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, petId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
