package ifri.dev.musicstreamingbackend.controllers;

import ifri.dev.musicstreamingbackend.dto.AlbumDto;
import ifri.dev.musicstreamingbackend.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @PostMapping("/")
    public ResponseEntity<String> createAlbum(@Valid @RequestBody AlbumDto payload) {
        albumService.create(payload);
        return ResponseEntity.ok().body("Album created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumDto> getAlbum(@PathVariable Long id) {
        return ResponseEntity.ok().body(albumService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<AlbumDto>> getAllAlbums() {
        return ResponseEntity.ok().body(albumService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlbum(@PathVariable Long id) {
        albumService.delete(id);
        return ResponseEntity.ok().body("Album deleted");
    }

    @PostMapping("/{id}/add-track")
    public ResponseEntity<?> addTrackToAlbum(@PathVariable Long id, @RequestParam Long trackId) {
        albumService.addTrack(id, trackId);
        return ResponseEntity.ok().body("Track added to album");
    }
}
