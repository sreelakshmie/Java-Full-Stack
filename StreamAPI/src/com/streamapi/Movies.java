package com.streamapi;

public class Movies {
    private String title;
    private int likes;
    private Genre genre;

    public String getTitle() {
        return title;
    }

    public int getLikes() {
        return likes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Movies(String title, int likes,Genre genre) {
        this.title = title;
        this.likes = likes;
        this.genre = genre;
    }


    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
