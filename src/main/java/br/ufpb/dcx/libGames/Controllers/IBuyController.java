package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Models.Value;
import br.ufpb.dcx.libGames.Models.Game;
import br.ufpb.dcx.libGames.Models.User;

public interface IBuyController {
    boolean BuyGame(User user, Game game, Value price);
    boolean refundGame(User user, Game game, Value price);

}
