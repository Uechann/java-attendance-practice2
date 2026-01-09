package attendance.domain.repository;

import attendance.domain.model.Crew;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class CrewRepository {

    private final Map<String, Crew> crewMap = new LinkedHashMap<>();

    public Crew save(Crew crew) {
        crewMap.put(crew.getName(), crew);
        return crew;
    }

    public Optional<Crew> findByName(String crewName) {
        return Optional.ofNullable(crewMap.get(crewName));
    }

    public boolean isExist(String crewName) {
        return crewMap.containsKey(crewName);
    }
}
