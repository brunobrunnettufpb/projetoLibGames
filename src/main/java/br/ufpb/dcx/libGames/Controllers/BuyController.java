package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Models.Game;
import br.ufpb.dcx.libGames.Models.User;
import br.ufpb.dcx.libGames.Models.Value;

public class BuyController implements IBuyController {
	public boolean BuyGame(User user, Game game, Value price) {
		return true;
	}

	public boolean refundGame(User user, Game game, Value price) {
		return true;
	}
}
