package com.akash.moviesindex.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.akash.moviesindex.db.Database;
import com.akash.moviesindex.db.FavouriteMoviesDAO;
import com.akash.moviesindex.model.tmdb.Movie;

import java.util.List;

public class Repository {
    private FavouriteMoviesDAO favouriteMoviesDAO;

    public Repository(Application application) {
        Database database = Database.getInstance(application);
        favouriteMoviesDAO = database.getFDAO();

    }

    public LiveData<List<Movie>> getAllFMovies() {
        return favouriteMoviesDAO.getAllFMovies();
    }

    public Movie getMovie(String id) {
        return favouriteMoviesDAO.getMovie(id);
    }

    public void AddMovie(Movie movie) {

        new AddFavouriteMovie(favouriteMoviesDAO).execute(movie);
    }

    public void DeleteMovie(Movie movie) {
        new DeleteFavouriteMovie(favouriteMoviesDAO).execute(movie);
    }

}
