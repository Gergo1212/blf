package com.blf.gameservice.repository;
import com.blf.gameservice.entity.League;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League, Long> {

}
