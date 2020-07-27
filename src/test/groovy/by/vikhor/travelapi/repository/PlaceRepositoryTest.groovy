package by.vikhor.travelapi.repository

import by.vikhor.travelapi.entity.Place
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification

@DataJpaTest
@TestPropertySource(locations = "classpath:/test.properties")
class PlaceRepositoryTest extends Specification {

    @Autowired
    private PlaceRepository placeRepository

    def "should find moscow place"() {
        given:
            def place = new Place()
            place.description="normplcae"
            place.name="Moscow"
            placeRepository.save(place)
        when:
            def moscow = placeRepository.findByNameIgnoreCase('moscow')
        then:
            moscow != null
    }

    def "shouldn't find Minsk place"() {
        given:
            def place = new Place()
            place.description="just place"
            place.name="Gomel"
            placeRepository.save(place)
        when:
            def moscow = placeRepository.findByNameIgnoreCase('minsk')
        then:
            moscow == null
    }
}
