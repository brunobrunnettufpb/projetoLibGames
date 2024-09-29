package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Models.Game;
import br.ufpb.dcx.libGames.Models.Value;

import java.util.HashMap;
import java.util.Map;

public class GameController {
    private Map<String, Game> games;

    public GameController() {
        games = new HashMap<>();
        games.put("witcher3", new Game(games.size()+1, "Witcher 3", "Action RPG", new Value(30, "BRL", "R$")));
        games.put("divinity2", new Game(games.size()+1, "Divinity 2", "Action RPG", new Value(25, "BRL", "R$")));
        games.put("baldursgate3", new Game(games.size()+1, "Baldurs Gate 3", "Action RPG", new Value(200, "BRL", "R$")));
    }

    public Map<String, Game> getGames() {
        return this.games;
    }
}
