package com.akash.moviesindex.repository;

import android.os.AsyncTask;

import com.akash.moviesindex.db.FavouriteMoviesDAO;
import com.akash.moviesindex.model.tmdb.Movie;

public class AddFavouriteMovie extends AsyncTask<Movie, Void, Void> {
    private FavouriteMoviesDAO favouriteMoviesDAO;

    public AddFavouriteMovie(FavouriteMoviesDAO favouriteMoviesDAO) {
        this.favouriteMoviesDAO = favouriteMoviesDAO;
    }

    @Override
    protected Void doInBackground(Movie... movies) {
        favouriteMoviesDAO.insertFMovie(movies[0]);
        return null;
    }
}
