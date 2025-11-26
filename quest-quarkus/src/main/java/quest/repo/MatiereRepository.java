package quest.repo;

import java.util.List;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import quest.model.Matiere;

@ApplicationScoped
public class MatiereRepository implements PanacheRepositoryBase<Matiere,Integer> {

	
	//public List<Matiere> findByLibelleContaining(String recherche);
	
	// @Query("SELECT m from Matiere m where m.libelle like :recherche")
	// public List<Matiere> findByContientLeLibelle(@Param("recherche") String recherche);
}
