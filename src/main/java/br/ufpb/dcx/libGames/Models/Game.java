package br.ufpb.dcx.libGames.Models;

import java.util.Objects;

public class Game {
    private int id;
    private String name;
    private String category;
    private Value price;

    public Game(int id, String name, String category, Value price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Value getPrice() {
        return price;
    }
    public void setPrice(Value price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;
        return id == game.id && name.equals(game.name) && Objects.equals(category, game.category) && Objects.equals(price, game.price);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + Objects.hashCode(price);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Jogo de ID {} possui o nome {} pertence a categoria {} e custa {}", id, name, category, price.getValue());
    }
}
