package org.example.SpringbootApp.services.implement;
import org.example.SpringbootApp.dto.ClubDto;
import org.example.SpringbootApp.models.Clubs;
import org.example.SpringbootApp.repository.ClubRepository;
import org.example.SpringbootApp.services.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImp implements ClubService {
    private ClubRepository clubRepository;

    public ClubServiceImp(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Clubs> clubs = clubRepository.findAll();
        return clubs.stream().map((clubs1) -> mapToClubDto(clubs1)).collect(Collectors.toList());
    }

    @Override
    public Clubs saveClub(ClubDto clubDto) {
        Clubs clubs = mapToClub(clubDto);
        return clubRepository.save(clubs);
    }

    @Override
    public ClubDto findClubById(long clubId) {
        Clubs club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Clubs club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    private Clubs mapToClub(ClubDto clubDto) {
        Clubs club = Clubs.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .photoUrl(clubDto.getPhotoUrl())
                .context(clubDto.getContext())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())
                .build();
        return club;
    }

    private ClubDto mapToClubDto(Clubs clubs){
        ClubDto clubDto = ClubDto.builder()
                .id(clubs.getId())
                .context(clubs.getContext())
                .title(clubs.getTitle())
                .createdOn(clubs.getCreatedOn())
                .updatedOn(clubs.getUpdatedOn())
                .photoUrl(clubs.getPhotoUrl())
                .build();
        return clubDto;
    }
}
