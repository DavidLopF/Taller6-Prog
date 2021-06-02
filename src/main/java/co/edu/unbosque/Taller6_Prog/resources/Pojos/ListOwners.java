package co.edu.unbosque.Taller6_Prog.resources.Pojos;

import java.util.List;

public class ListOwners {
    private int all;
    private List<DiscriminateOwnersPets> discriminateOwnersPets;


    public ListOwners() {
    }


    public ListOwners(int countOwners, List<DiscriminateOwnersPets> discriminateOwnersPets) {
        this.all = countOwners;
        this.discriminateOwnersPets = discriminateOwnersPets;
    }
    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public List<DiscriminateOwnersPets> getDiscriminateOwnersPets() {
        return discriminateOwnersPets;
    }

    public void setDiscriminateOwnersPets(List<DiscriminateOwnersPets> discriminateOwnersPets) {
        this.discriminateOwnersPets = discriminateOwnersPets;
    }
}
