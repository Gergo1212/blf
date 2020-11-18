package com.blf.gameservice.dao;
import com.blf.gameservice.dto.PlayerWrapper;
import com.blf.gameservice.entity.Player;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlayerDao {

    List<Player> getAllPlayers();

    Player getPlayerById(Long id);

    Player addPlayer(Player player);

    Player updatePlayer(Long id, Player player);

    Player deletePlayer(Long id);

    Page<Player> getAllPaginatedPlayers(int page);

}