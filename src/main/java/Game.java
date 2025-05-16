import java.util.Objects;

public class Game {
    private String name;
    private double rating;
    private int price;

    public Game(String name, double rating, int price) {
        setName(name);
        setRating(rating);
        setPrice(price);
    }

    public String getName() {
        return name;
    }


    public double getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Game: %s\nRating: %f/5\nPrice: %d€" , name, rating, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Double.compare(game.rating, rating) == 0 && Double.compare(game.price, price) == 0 && Objects.equals(name, game.name);
    }

}
