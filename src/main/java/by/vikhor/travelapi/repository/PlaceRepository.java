package by.vikhor.travelapi.repository;

import by.vikhor.travelapi.entity.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "places", collectionResourceRel = "places")
public interface PlaceRepository extends CrudRepository<Place, Long> {
    Place findByNameIgnoreCase(String name);
}
