package resource.optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {


        Author author1 = new Author("au1", "au@test.com", new Book("book1", null));


        var sellPercentage = Optional.ofNullable(author1)
                .map(Author::book)
                .map(Book::sellNo)
                .map(sellNum -> sellNum * 10)
                .orElseGet(OptionalDemo::defaultSellProfit);

        System.out.println("sellPercentage is:" + sellPercentage + "%");

        Optional<Author> emptyAuthor = Optional.empty(); // db return empty optional

        emptyAuthor.ifPresentOrElse(author -> System.out.println(author.book()),
                () -> System.out.println("No author present")); // use it when no return , accepts consumer

        var defaultAuthor = emptyAuthor
                .orElseGet(OptionalDemo::defaultAuthor); // use orElseGet when u want to return something , accepts supplier

        System.out.println("default author: " + defaultAuthor);
    }

    private static Author defaultAuthor() {
        return new Author("default", "default@test.com", new Book("default", 1));
    }

    private static Integer defaultSellProfit() {
        return 20;
    }
}