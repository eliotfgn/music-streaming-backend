package ifri.dev.musicstreamingbackend.controllers;

import ifri.dev.musicstreamingbackend.dto.ArtistDto;
import ifri.dev.musicstreamingbackend.services.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/artists")
@AllArgsConstructor
public class ArtistController {
    private ArtistService artistService;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody @Valid ArtistDto payload) {
        artistService.create(payload);
        return ResponseEntity.ok("Artist created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(artistService.getArtist(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(artistService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid ArtistDto payload) {
        artistService.update(id, payload);
        return ResponseEntity.ok("Artist updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        artistService.delete(id);
        return ResponseEntity.ok("Artist deleted successfully");
    }
}
