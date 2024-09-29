package br.ufpb.dcx.libGames.Controllers;

import br.ufpb.dcx.libGames.Models.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BuyController implements IBuyController {
	private Map<Integer, Buy> boughts;

	public BuyController() {
		boughts = new LinkedHashMap<>();
	}

	public boolean BuyGame(User user, Game game, Value price) {
		int lastBuyId = boughts.size()+1;

		return true;
	}

	public boolean RefundGame(User user, Game game, Value price) {
		return true;
	}
}
