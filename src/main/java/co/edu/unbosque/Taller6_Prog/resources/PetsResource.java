package co.edu.unbosque.Taller6_Prog.resources;


import co.edu.unbosque.Taller6_Prog.resources.Pojos.Notification;
import co.edu.unbosque.Taller6_Prog.resources.Pojos.Pet;
import co.edu.unbosque.Taller6_Prog.resources.Pojos.Picture;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/owners/{owner_id}/pets")
public class PetsResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)


    public Response create(@PathParam("owner_id") Integer ownerId,Pet pet) {
        pet.setPet_id(3);
        return Response.status(Response.Status.CREATED)
                .entity(pet)
                .build();
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadPicture(@PathParam("owner_id") Integer ownerId, Picture p) {
        Pet pet = new Pet();
        pet.setOwner_id(ownerId);
        pet.setName("Name by owner "+ownerId);
        pet.setMicrochip(12355);
        pet.setSpecies("Specie by owner "+ownerId);
        pet.setSize("Size by owner "+ownerId);
        pet.setRace("Race by owner "+ownerId);
        pet.setPet_id(1);
        pet.setPicture(p);
        return Response.status(Response.Status.CREATED)
                .entity(pet)
                .build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("owner_id") int owner_id, @QueryParam("valor") String valor, @QueryParam("filtro") int filtro) {

        List<Pet> mascotas = new ArrayList<Pet>();
        Random rnd = new Random();
        String[] size = {"grande", "pequeño", "mediano", "muy grande"};
        String[] specie = {"perro", "gato"};
        String[] sex = {"femenino", "masculino"};
        String[] names = {"copito", "galleta", "tayson", "aslan", "sergio", "danger", "masacre", "stan", "json"};

        for (int i = 0; i < 20; i++) {
            int id = rnd.nextInt(10000);
            if (i % 2 == 0) {
                mascotas.add(new Pet(id,
                        1234567891, "pet" + i, specie[rnd.nextInt(specie.length)], "pet_race",
                        size[rnd.nextInt(size.length)], sex[rnd.nextInt(sex.length)], rnd.nextInt(11)));
            } else {
                mascotas.add(new Pet(id,
                        rnd.nextLong(), names[rnd.nextInt(names.length)], specie[rnd.nextInt(specie.length)], "pet_race",
                        size[rnd.nextInt(size.length)], sex[rnd.nextInt(sex.length)], owner_id));
            }
        }
        List<Pet> petsFiltradas = new ArrayList();
        for (Pet pet : mascotas) {
            if (pet.getOwner_id().equals(owner_id) && filtro == 0) {
                petsFiltradas.add(pet);
            } else if (filtro == 1) {
                if (pet.getMicrochip() == Long.parseLong(valor)) {
                    petsFiltradas.add(pet);
                }
            } else if (pet.getName().equals(valor) && filtro == 2) {
                petsFiltradas.add(pet);
            } else if (pet.getSpecies().equals(valor) && filtro == 3) {
                petsFiltradas.add(pet);
            } else if (pet.getRace().equals(valor) && filtro == 4) {
                petsFiltradas.add(pet);
            } else if (pet.getSize().equals(valor) && filtro == 5) {
                petsFiltradas.add(pet);
            } else if (pet.getSex().equals(valor) && filtro == 6) {
                petsFiltradas.add(pet);
            }
        }
        return Response.ok().entity(petsFiltradas).build();
    }


}
