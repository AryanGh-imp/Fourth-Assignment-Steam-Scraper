import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.util.Collections.unmodifiableList;

public class Parser {
    static List<Game> games = new ArrayList<>();

    public List<Game> sortByName(){
        return games.stream().sorted(Comparator.comparing(Game::getName)).toList();
    }

    public List<Game> sortByRating() {
        return games.stream()
                .sorted(Comparator.comparing(Game::getRating).reversed())
                .toList();
    }

    public List<Game> sortByPrice() {
        return games.stream()
                .sorted(Comparator.comparing(Game::getPrice).reversed())
                .toList();
    }

    public static List<Game> getGames() {
        return unmodifiableList(games);
    }

    public void setUp() throws IOException {
        File input = new File("src/Resources/Video_Games.html");
        Document doc = Jsoup.parse(input, "UTF-8");

        Elements gameElements = doc.select("div.col-md-4.game");

        for (Element gameElement : gameElements) {
            String name = gameElement.selectFirst("h3.game-name").text();

            String ratingText = gameElement.selectFirst("span.game-rating").text();
            double rating = Double.parseDouble(ratingText.split("/")[0]);

            String priceText = gameElement.selectFirst("span.game-price").text();
            int price = Integer.parseInt(priceText.replace("€", "").trim());

            games.add(new Game(name, rating, price));
        }
    }

    public static void main(String[] args) {
        //you can test your code here before you run the unit tests
    }
}
