package app.repository;

import app.entity.Composition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CompositionRepository extends CrudRepository<Composition, Integer> {

}
