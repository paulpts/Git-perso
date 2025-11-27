package quest.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import quest.model.Utilisateur;

@ApplicationScoped
public class UtilisateurRepository implements PanacheRepositoryBase<Utilisateur, String> {

}
