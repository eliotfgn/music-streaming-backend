package ifri.dev.musicstreamingbackend.controllers;

import ifri.dev.musicstreamingbackend.dto.PlaylistDto;
import ifri.dev.musicstreamingbackend.services.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/playlists")
@AllArgsConstructor
public class PlaylistController {
    private PlaylistService playlistService;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody @Valid PlaylistDto payload) {
        playlistService.create(payload);
        return ResponseEntity.ok("Playlist created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(playlistService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid PlaylistDto payload) {
        playlistService.update(id, payload);
        return ResponseEntity.ok("Playlist updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        playlistService.delete(id);
        return ResponseEntity.ok("Playlist deleted successfully");
    }

    @PostMapping("/{id}/tracks/{trackId}")
    public ResponseEntity<?> addTrack(@PathVariable Long id, @PathVariable Long trackId) {
        playlistService.addTrack(id, trackId);
        return ResponseEntity.ok("Track added successfully");
    }
}
