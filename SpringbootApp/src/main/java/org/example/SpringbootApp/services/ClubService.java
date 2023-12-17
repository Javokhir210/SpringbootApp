package org.example.SpringbootApp.services;
import org.example.SpringbootApp.dto.ClubDto;
import org.example.SpringbootApp.models.Clubs;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Clubs saveClub(ClubDto clubDto);

    ClubDto findClubById(long clubId);

    void updateClub(ClubDto clubDto);
}
