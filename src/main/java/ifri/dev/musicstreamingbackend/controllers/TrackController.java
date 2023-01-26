package ifri.dev.musicstreamingbackend.controllers;

import ifri.dev.musicstreamingbackend.dto.TrackDto;
import ifri.dev.musicstreamingbackend.services.TrackService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tracks")
@AllArgsConstructor
public class TrackController {
    private TrackService trackService;

    @PostMapping("/")
    public ResponseEntity<String> create(@Valid @RequestBody TrackDto payload) {
        trackService.create(payload);
        return new ResponseEntity("New track added.",HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<TrackDto>> getAllTracks() {
        return ResponseEntity.ok().body(trackService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(trackService.getTrack(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        trackService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
