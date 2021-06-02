package co.edu.unbosque.Taller6_Prog.resources;

import co.edu.unbosque.Taller6_Prog.resources.Pojos.ListOwners;
import co.edu.unbosque.Taller6_Prog.resources.Pojos.DiscriminateOwnersPets;
import co.edu.unbosque.Taller6_Prog.resources.Pojos.Pet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/allPets")

public class allPets {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response create() {
        List<Pet> mascotas = new ArrayList<Pet>();
        Random rnd = new Random();
        String[] size = {"grande", "pequeño", "mediano", "muy grande"};
        String[] specie = {"perro", "gato"};
        String[] sex = {"femenino", "masculino"};

        for (int i = 0; i < 20; i++) {
            int id = rnd.nextInt(10000);
            if (i % 2 == 0) {
                mascotas.add(new Pet(specie[rnd.nextInt(specie.length)], "pet_race", size[rnd.nextInt(size.length)],
                                     sex[rnd.nextInt(sex.length)], 1234567891));
            } else {
                mascotas.add(new Pet(specie[rnd.nextInt(specie.length)], "pet_race", size[rnd.nextInt(size.length)],
                                sex[rnd.nextInt(sex.length)], 1983726254));
            }
        }

        List<DiscriminateOwnersPets> locations = new ArrayList<DiscriminateOwnersPets>();
        ListOwners listOwners = new ListOwners(mascotas.size(), locations);
        specie(mascotas, listOwners, "perro", listOwners.getDiscriminateOwnersPets());
        specie(mascotas, listOwners, "gato", listOwners.getDiscriminateOwnersPets());
        race(mascotas, listOwners, "pet_race", listOwners.getDiscriminateOwnersPets());
        microchip(mascotas, listOwners, 1234567891 , listOwners.getDiscriminateOwnersPets());
        microchip(mascotas, listOwners, 1983726254 , listOwners.getDiscriminateOwnersPets());
        size(mascotas, listOwners, "grande", listOwners.getDiscriminateOwnersPets());
        size(mascotas, listOwners, "pequeño", listOwners.getDiscriminateOwnersPets());
        size(mascotas, listOwners, "mediano", listOwners.getDiscriminateOwnersPets());
        size(mascotas, listOwners, "muy grande", listOwners.getDiscriminateOwnersPets());
        sex(mascotas, listOwners, "femenino", listOwners.getDiscriminateOwnersPets());
        sex(mascotas, listOwners, "masculino", listOwners.getDiscriminateOwnersPets());

        return Response.status(Response.Status.CREATED)
                .entity(listOwners)
                .build();
    }
    private void specie(List<Pet> pets, ListOwners listOwners, String name, List<DiscriminateOwnersPets> discriminateOwnersPets) {
        int count = 0;
        for (Pet pet : pets) {
            if (pet.getSpecies().equals(name)) {
                count = getCount(listOwners, name, discriminateOwnersPets, count);
            }
        }
    }
    private void race (List<Pet> pets, ListOwners listOwners, String name, List<DiscriminateOwnersPets> discriminateOwnersPets) {
        int count = 0;
        for (Pet pet : pets) {
            if (pet.getRace().equals(name)) {
                count = getCount(listOwners, name, discriminateOwnersPets, count);
            }
        }
    }

    private void microchip (List<Pet> pets, ListOwners listOwners, long microchip, List<DiscriminateOwnersPets> discriminateOwnersPets) {
        int count = 0;
        String name = String.valueOf(microchip);
        for (Pet pet : pets) {
            if (pet.getMicrochip() == microchip) {
                count = getCount(listOwners, name, discriminateOwnersPets, count);
            }
        }
    }
    private void size (List<Pet> pets, ListOwners listOwners, String name, List<DiscriminateOwnersPets> discriminateOwnersPets) {
        int count = 0;
        for (Pet pet : pets) {
            if (pet.getSize().equals(name)) {
                count = getCount(listOwners, name, discriminateOwnersPets, count);
            }
        }
    }
    private void sex (List<Pet> pets, ListOwners listOwners, String name, List<DiscriminateOwnersPets> discriminateOwnersPets) {
        int count = 0;
        for (Pet pet : pets) {
            if (pet.getSex().equals(name)) {
                count = getCount(listOwners, name, discriminateOwnersPets, count);
            }
        }
    }

    static int getCount(ListOwners listOwners, String name, List<DiscriminateOwnersPets> discriminateOwnersPets, int count) {
        for(int i = 0; i < discriminateOwnersPets.size(); i++){
            if (discriminateOwnersPets.get(i).getName().equals(name)) {
                count++;
            }
        }
        if (count == 0) {
            discriminateOwnersPets.add(new DiscriminateOwnersPets(1, name));
        } else {
            for (int i = 0; i < discriminateOwnersPets.size(); i++) {
                if (discriminateOwnersPets.get(i).getName().equals(name)) {
                    discriminateOwnersPets.get(i).setCount(listOwners.getDiscriminateOwnersPets().get(i).getCount() + 1);
                }
            }
        }
        return count;
    }

}
