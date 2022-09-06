package dev.mjlee.bemjlee.Player;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getplayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getplayer(Long playerId) {
        if (!playerRepository.existsById(playerId))
            throw new IllegalStateException("player " + playerId + " not found");
        else
            return playerRepository.findById(playerId);
    }

    public List<Player> getTop5players() {
        return playerRepository.findTop5ByOrderByScoreDesc();
    }

    public void addplayer(Player player) {
        playerRepository.save(player);
    }

    public void deleteplayer(Long player) {
        playerRepository.findById(player);
        if (!playerRepository.existsById(player)) {
            throw new IllegalStateException("Project " + player + " not found");
        } else {
            playerRepository.deleteById(player);
        }
    }
}
