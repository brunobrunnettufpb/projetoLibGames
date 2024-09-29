package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Models.Game;
import br.ufpb.dcx.libGames.Models.User;
import br.ufpb.dcx.libGames.Models.Value;

public interface IBuyController {
    boolean BuyGame(User user, Game game, Value price);
    boolean RefundGame(User user, Game game, Value price);

}
