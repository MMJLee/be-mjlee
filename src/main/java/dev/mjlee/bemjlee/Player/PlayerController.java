package dev.mjlee.bemjlee.Player;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "players")
@CrossOrigin(origins = "http://localhost:8080")
// @CrossOrigin(origins = "https://mjlee.dev", allowedHeaders = "*",
// allowCredentials = "true")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(path = "/")
    public List<Player> getplayers() {
        return playerService.getplayers();
    }

    @GetMapping(path = "/top5/")
    public List<Player> getTop5players() {
        return playerService.getTop5players();
    }

    @GetMapping(path = "/{id}/")
    public Optional<Player> getplayer(@PathVariable("id") Long id) {
        return playerService.getplayer(id);
    }

    @PostMapping(path = "/")
    public void registeplayer(@RequestBody Player player) {
        playerService.addplayer(player);
    }

    @DeleteMapping(path = "/statement/{id}/")
    public void deleteplayer(@PathVariable("id") Long id) {
        playerService.deleteplayer(id);
    }

    // cleaner method, but commas aren't url standard
    // @PutMapping(path = "/game/used/{ids}")
    // public void setStatementsUsed(@PathVariable("ids") Long[] ids) {
    // statementService.setStatementsUsed(ids);
    // }
}