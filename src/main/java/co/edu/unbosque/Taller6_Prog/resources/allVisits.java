package co.edu.unbosque.Taller6_Prog.resources;

import co.edu.unbosque.Taller6_Prog.resources.Pojos.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/allVisits")
public class allVisits {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response create() {
        List<Visit> visit = new ArrayList<Visit>();
        List<Vet> vet = new ArrayList<Vet>();
        String[] tipos = {"esterilizacion", "implantación de microchip",
                "vacunación", "desparasitación", "urgencia", "control"};
        String[] veterinaria = {"Veterinaria Las Rosas", "Veterinaria la que no falla", "Veterinaria de las buenas",
                "Veterinaria warzone", "Veterinaria verdansk", "Veterinaria TrainStation"};
        Random rnd = new Random();
        for (int i = 0; i < 25; i++) {
            int id = rnd.nextInt(10000);
            visit.add(new Visit(tipos[rnd.nextInt(tipos.length)]));
            vet.add(new Vet(veterinaria[rnd.nextInt(veterinaria.length)]));
        }
        List<DiscriminateOwnersPets> discriminateOwnersPets = new ArrayList<DiscriminateOwnersPets>();
        ListOwners listOwners = new ListOwners(visit.size(), discriminateOwnersPets);
        visitByType(visit, listOwners, "esterilizacion", listOwners.getDiscriminateOwnersPets());
        visitByType(visit, listOwners, "implantación de microchip", listOwners.getDiscriminateOwnersPets());
        visitByType(visit, listOwners, "vacunación", listOwners.getDiscriminateOwnersPets());
        visitByType(visit, listOwners, "desparasitación", listOwners.getDiscriminateOwnersPets());
        visitByType(visit, listOwners, "urgencia", listOwners.getDiscriminateOwnersPets());
        visitByType(visit, listOwners, "control", listOwners.getDiscriminateOwnersPets());
        visitByVet(vet, listOwners, "Veterinaria Las Rosas", listOwners.getDiscriminateOwnersPets());
        visitByVet(vet, listOwners, "Veterinaria la que no falla", listOwners.getDiscriminateOwnersPets());
        visitByVet(vet, listOwners, "Veterinaria de las buenas", listOwners.getDiscriminateOwnersPets());
        visitByVet(vet, listOwners, "Veterinaria warzone", listOwners.getDiscriminateOwnersPets());
        visitByVet(vet, listOwners, "Veterinaria verdansk", listOwners.getDiscriminateOwnersPets());
        visitByVet(vet, listOwners, "Veterinaria TrainStation", listOwners.getDiscriminateOwnersPets());

        return Response.status(Response.Status.CREATED)
                .entity(listOwners)
                .build();
    }

    private void visitByType(List<Visit> visits, ListOwners listOwners, String name, List<DiscriminateOwnersPets> discriminateOwnersPets) {
        int count = 0;
        for (Visit visit : visits) {
            if (visit.getType().equals(name)) {
                count = allPets.getCount(listOwners, name, discriminateOwnersPets, count);
            }
        }

    }

    private void visitByVet(List<Vet> visitByVet, ListOwners listOwners, String name, List<DiscriminateOwnersPets> discriminateOwnersPets) {
        int count = 0;
        for (Vet vet : visitByVet) {
            if (vet.getName().equals(name)) {
                count = allPets.getCount(listOwners, name, discriminateOwnersPets, count);
            }
        }
    }
}
