package ifri.dev.musicstreamingbackend.mappers;

import ifri.dev.musicstreamingbackend.dto.ArtistDto;
import ifri.dev.musicstreamingbackend.models.Artist;

public class ArtistMapper {
    public static ArtistDto mapToDto(Artist artist) {
        return ArtistDto.builder()
                .id(artist.getId())
                .name(artist.getName())
                .bio(artist.getBio())
                .profilePic(artist.getProfilePic())
                .followersCount(artist.getFollowersCount())
                .build();
    }

    public static Artist mapToEntity(ArtistDto dto) {
        return Artist.builder()
                .id(dto.getId())
                .name(dto.getName())
                .bio(dto.getBio())
                .profilePic(dto.getProfilePic())
                .followersCount(dto.getFollowersCount())
                .build();
    }
}
