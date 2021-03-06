package com.akash.moviesindex.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.akash.moviesindex.R;
import com.akash.moviesindex.databinding.ReviewListItemBinding;
import com.akash.moviesindex.model.tmdb.Review;
import com.akash.moviesindex.model.tmdb.ReviewsList;

public class ReviewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ReviewsList reviewsList;

    public ReviewsAdapter(ReviewsList reviewsList) {
        this.reviewsList = reviewsList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        ReviewListItemBinding reviewListViewBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.review_list_item, viewGroup, false);
        return new ReviewsViewHolder(reviewListViewBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ReviewsViewHolder) {
            Review review = reviewsList.getResults().get(i);
            ((ReviewsViewHolder) viewHolder).reviewListViewBinding.setReview(review);
        }
    }

    static class ReviewsViewHolder extends RecyclerView.ViewHolder {
        private ReviewListItemBinding reviewListViewBinding;

        ReviewsViewHolder(@NonNull final ReviewListItemBinding reviewListViewBinding) {
            super(reviewListViewBinding.getRoot());
            this.reviewListViewBinding = reviewListViewBinding;
        }
    }

    @Override
    public int getItemCount() {
        return reviewsList == null || reviewsList.getResults() == null ? 0 : reviewsList.getResults().size();
    }

}

