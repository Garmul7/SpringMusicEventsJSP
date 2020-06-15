package pl.dmcs.garmul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.garmul.model.MusicEvent;

@Repository
public interface MusicEventRepository extends JpaRepository<MusicEvent, Long> {
    MusicEvent findById(long id);
}
