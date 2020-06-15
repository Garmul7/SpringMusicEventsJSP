package pl.dmcs.garmul.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.garmul.model.MusicEvent;
import pl.dmcs.garmul.repository.MusicEventRepository;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/restApi/events")
public class MusicEventRESTController {
    private MusicEventRepository musicEventRepository;

    @Autowired
    public MusicEventRESTController(MusicEventRepository musicEventRepository) {
        this.musicEventRepository = musicEventRepository;
    }

    @RequestMapping(method = RequestMethod.GET/*, produces = "application/xml"*/)
    //@GetMapping
    public List<MusicEvent> findAllMusicEvents() {
        return musicEventRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    //@PostMapping

    public ResponseEntity<MusicEvent> addMusicEvent(@RequestBody MusicEvent musicEvent) {
        musicEventRepository.save(musicEvent);
        return new ResponseEntity<MusicEvent>(musicEvent, HttpStatus.CREATED);
    }


    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    //@PutMapping("/{id}")
    public ResponseEntity<MusicEvent> updateMusicEvent(@RequestBody MusicEvent musicEvent, @PathVariable("id") long id) {
        musicEvent.setId(id);
        musicEventRepository.save(musicEvent);
        return new ResponseEntity<MusicEvent>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PATCH)
    //@PatchMapping("/{id}")
    public ResponseEntity<MusicEvent> updatePartOfMusicEvent(@RequestBody Map<String, Object> updates, @PathVariable("id") long id) {
        MusicEvent musicEvent = musicEventRepository.findById(id);
        if (musicEvent == null) {
            System.out.println("Music Event not found!");
            return new ResponseEntity<MusicEvent>(HttpStatus.NOT_FOUND);
        }
        partialUpdate(musicEvent,updates);
        return new ResponseEntity<MusicEvent>(HttpStatus.NO_CONTENT);
    }
// for now only eventIsActive
    private void partialUpdate(MusicEvent musicEvent, Map<String, Object> updates) {
        if (updates.containsKey("eventIsActive")) {
            musicEvent.setEventIsActive((Boolean) updates.get("eventIsActive"));
        }

        musicEventRepository.save(musicEvent);
    }
}
