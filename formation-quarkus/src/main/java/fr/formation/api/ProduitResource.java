package fr.formation.api;

import fr.formation.dto.request.CreateProduitRequest;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/produit")
public class ProduitResource {

    @GET
    public String findByIdQuery(@QueryParam("id") int id) {
        return "Produit " + id + "!";
    }

    @GET
    @Path("/{id}")
    public String findByIdPath(@PathParam("id") int id) {
        return "Produit " + id + "!";
    }

    @GET
    @Path("/create")
    public String findByIdBean(@BeanParam CreateProduitRequest produit) {

        return produit.getLibelle() + " : " + produit.getPrix() + "€";
    }

}
