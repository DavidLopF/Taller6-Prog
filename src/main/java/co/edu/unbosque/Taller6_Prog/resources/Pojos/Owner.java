package co.edu.unbosque.Taller6_Prog.resources.Pojos;

import java.util.ArrayList;

public class Owner {

    private String username;
    private Integer person_id;
    private String name;
    private String address;
    private String neighborhood;
    private ArrayList<Pet> pets;


    public Owner(){
    }

    public Owner(String username, Integer person_id, String name, String address, String neighborhood) {
        this.username = username;
        this.person_id = person_id;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
        pets = new ArrayList<>();
    }

    public void addPet(Pet e){
        pets.add(e);
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }


}
