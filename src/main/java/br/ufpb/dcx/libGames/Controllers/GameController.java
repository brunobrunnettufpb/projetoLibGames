package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Models.Game;
import br.ufpb.dcx.libGames.Models.Value;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameController {
    private Map<String, Game> games;
    private GravadorDeDadosController gravador = new GravadorDeDadosController();

    // TODO: Cadastrar, persistir e recuperar a lista de jogos.
    public GameController() {
        games = new LinkedHashMap<>();
        try {
            this.games = gravador.LoadGames();
        }
        catch (Exception ex) {
            // TODO: Finalizar de forma adequada, criando um adicionador de jogos.
            games.put("Witcher 3", new Game(games.size()+1, "Witcher 3", "Action RPG", new Value(30, "BRL", "R$")));
            games.put("Divinity 2", new Game(games.size()+1, "Divinity 2", "Turn Based RPG", new Value(25, "BRL", "R$")));
            games.put("Baldurs Gate 3", new Game(games.size()+1, "Baldurs Gate 3", "Turn Based RPG", new Value(200, "BRL", "R$")));
        }
    }

    public Map<String, Game> getGames() {
        return this.games;
    }

    public Game getGame(String gameName) {
        return this.games.get(gameName);
    }

    public Game getGame(int id) {
        for (Game game: games.values()) {
            if (game.getId() == id) {
                return game;
            }
        }

        return null;
    }

    public int getQtdGames() {
        return this.games.size();
    }

    @Override
    public String toString() {
        // TODO: Relatório dos jogos cadastrados.
        return "";
    }
}
