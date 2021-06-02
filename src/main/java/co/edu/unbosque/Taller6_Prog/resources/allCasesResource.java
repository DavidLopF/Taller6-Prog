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

@Path("/allCases")
public class allCasesResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response create() {
        List<Case>caso = new ArrayList<Case>();
        String[] tipos = {"perdida", "robo", "fallecimiento"};
        Random rnd = new Random();
        for (int i = 0; i < 15; i++) {
            int id = rnd.nextInt(10000);
            caso.add(new Case(tipos[rnd.nextInt(tipos.length)]));
        }
        List<DiscriminateOwnersPets> discriminateOwnersPets = new ArrayList<DiscriminateOwnersPets>();
        ListOwners listOwners = new ListOwners(caso.size(), discriminateOwnersPets);
        casesType(caso, listOwners, "perdida", listOwners.getDiscriminateOwnersPets());
        casesType(caso, listOwners, "robo", listOwners.getDiscriminateOwnersPets());
        casesType(caso, listOwners, "fallecimiento", listOwners.getDiscriminateOwnersPets());

        return Response.status(Response.Status.CREATED)
                .entity(listOwners)
                .build();
    }

    private void casesType(List<Case> cases, ListOwners listOwners, String name, List<DiscriminateOwnersPets> discriminateOwnersPets) {
        int count = 0;
        for (Case caso : cases) {
            if (caso.getType().equals(name)) {
                count = allPetsResource.getCount(listOwners, name, discriminateOwnersPets, count);
            }
        }
    }
}
