package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.List;

public interface IFilmProfessional {

  void addMovie(Movie movie);

  void addTVSeries(TVSeries series);

  void addMedia(Movie movie);

  void addMedia(TVSeries series);

  Name getName();

  List<Movie> getMovies();

  List<TVSeries> getTVSeries();

  List<IFilmMedia> getMedia();
}
