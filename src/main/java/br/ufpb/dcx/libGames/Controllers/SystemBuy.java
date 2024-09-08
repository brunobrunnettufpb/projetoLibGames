package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Models.Value;
import br.ufpb.dcx.libGames.Models.Game;
import br.ufpb.dcx.libGames.Models.User;

public interface SystemBuy {
    void BuyGame(User user, Game game, Value price);
}
