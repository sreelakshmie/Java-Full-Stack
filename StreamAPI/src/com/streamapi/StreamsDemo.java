package com.streamapi;

import java.util.List;
import java.util.function.Predicate;

public class StreamsDemo {
    public void streamsDemo(){
    List<Movies> movies = List.of(
            new Movies("a",10,Genre.ACTION),
            new Movies("d",30,Genre.COMEDY),
            new Movies("h",50,Genre.FANTACY),
            new Movies("s",20,Genre.HORROR),
            new Movies("s",20,Genre.ROMANTIC),
            new Movies("c",60,Genre.THRILLER)
    );

    var result = movies.stream()
            .allMatch(m -> m.getLikes() <20);
        System.out.println(result);

        movies.stream()
                .filter(m -> m.getLikes()>10)
            .peek(m -> System.out.println("filtered "+m.getTitle()))
            .map(Movies::getTitle)
                .peek(t -> System.out.println("mappped "+t))
            .forEach(System.out::println);

        movies.stream()
                .skip(2)
                .forEach(m -> System.out.println(m.getTitle()));

        Predicate<Movies> isPopular = m -> m.getLikes() > 10;
        movies.stream()
                .filter(isPopular)
                .forEach(m -> System.out.println(m.getTitle()));


        movies.stream()
                .filter(m -> m.getLikes() > 10)
            .forEach(m -> System.out.println(m.getTitle()));


        movies.stream()
                .map(movie -> movie.getTitle() )
            .forEach(name -> System.out.println(name));
}

}