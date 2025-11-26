package quest.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quest.repo.MatiereRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;



import quest.model.Matiere;


@ApplicationScoped
public class MatiereService {
	
	private final static Logger log = LoggerFactory.getLogger(MatiereService.class);
	
	
	private final MatiereRepository repoMatiere;
	
	public MatiereService(MatiereRepository repoMatiere) {
		this.repoMatiere=repoMatiere;
	}
	
	public Optional<Matiere> getById(Integer id)
	{
		log.error("On pioche la matiere{} dans la base de données",id);
		return this.repoMatiere.findByIdOptional(id);
	}
	
	public List<Matiere> getAll()
	{
		return this.repoMatiere.findAll().list();
	}
	
	// public List<Matiere> getAllByLibelleLike(String recherche)
	// {
	// 	return this.repoMatiere.findByLibelleContaining(recherche).list();
	// }
	
	@Transactional
	public Matiere create(Matiere request) 
	{
		Matiere matiere = new Matiere();
		
		matiere.setLibelle(request.getLibelle());
		
		this.repoMatiere.persist(matiere);
		return matiere;
	}
	
	@Transactional
	public Matiere update(int id, Matiere request) 
	{
		log.debug("Mise à jour de la matiere {}", id);
		
		Matiere matiere = this.repoMatiere.findByIdOptional(id).orElseThrow();

		matiere.setLibelle(request.getLibelle());
		
		this.repoMatiere.persist(matiere);
		return matiere;
	}
	

	@Transactional
	public void deleteById(Integer id) 
	{
		log.debug("Suppression de la matiere {}", id);

		this.repoMatiere.deleteById(id);
	}
	
	
}
