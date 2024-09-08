package br.ufpb.dcx.libGames.Models;

import java.util.Date;
import java.util.Objects;

public class Buy {
    private User user;
    private Game game;
    private Value value;
    private Date buyDate;
    private String buyTime;

    public Buy(User user, Game game, Value value, Date buyDate, String buyTime) {
        this.user = user;
        this.game = game;
        this.value = value;
        this.buyDate = buyDate;
        this.buyTime = buyTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buy buy = (Buy) o;
        return user.equals(buy.user) && game.equals(buy.game) && value.equals(buy.value) && Objects.equals(buyDate, buy.buyDate) && Objects.equals(buyTime, buy.buyTime);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + game.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + Objects.hashCode(buyDate);
        result = 31 * result + Objects.hashCode(buyTime);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Compra do jogo {} realizada por {} no dia {}, hora {}, custou {}", this.game.getName(), this.user.getName(), this.buyDate, this.buyTime, this.value.getValue());
    }
}
