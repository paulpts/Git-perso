package quest.api;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import quest.model.Matiere;
import quest.service.MatiereService;


@Path("/api/matiere")
public class MatiereResource {
	
	private final static Logger log = LoggerFactory.getLogger(MatiereResource.class);
	
	@Inject
	MatiereService matiereSrv;
	
	public MatiereResource(MatiereService matiereService) {
		this.matiereSrv = matiereService;
	}
	
	@GET
	public List<Matiere> allMatieres() {
		log.error("On recherche toutes les matieres");
		return matiereSrv.getAll();
	}

	@GET
	@Path("/{id}")
	public Response ficheMatiere(@PathParam("id") Integer id) {
		log.error("On recherche la matiere{}", id);
		Optional<Matiere> optMatiere = matiereSrv.getById(id);
		
		if (optMatiere.isEmpty()) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok(optMatiere.get()).build();
	}
	
	@POST
	public Response ajoutMatiere(@Valid Matiere request) {
		
		log.debug("Le nom de la matiere est : {}", request.getLibelle());

		Matiere matiere = this.matiereSrv.create(request);

		      return Response.status(Status.CREATED)
                .entity(Map.of("id", matiere.getId()))
                .build();
	}
	
	@PUT
	@Path("/{id}")
	public Response modifierMatiere(@PathParam ("id") Integer id, Matiere request) {
        log.debug("Le nom de la matiere est : {}", request.getLibelle());

        this.matiereSrv.update(id, request);

        return Response.ok(id).build();

	}
	
	@DELETE
	@Path("/{id}")
	public Response supprimerMatiere(@PathParam("id") Integer id) {
		log.debug("Suppression de la matiere {}", id);

        this.matiereSrv.deleteById(id);

        return Response.ok(id).build();
	}
	
}
