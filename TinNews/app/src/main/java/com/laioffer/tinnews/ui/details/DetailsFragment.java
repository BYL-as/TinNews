package com.laioffer.tinnews.ui.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.databinding.FragmentDetailsBinding;
import com.laioffer.tinnews.model.Article;
import com.squareup.picasso.Picasso;

public class DetailsFragment extends Fragment {
    private FragmentDetailsBinding binding;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =  FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Article article = DetailsFragmentArgs.fromBundle(getArguments()).getArticle();

        binding.detailsAuthorTextView.setText(article.author);
        binding.detailsTitleTextView.setText(article.title);
        binding.detailsDateTextView.setText(article.publishedAt);
        binding.detailsContentTextView.setText(article.content + article.content);
        binding.detailsDescriptionTextView.setText(article.description + article.description);
        Picasso.get().load(article.urlToImage).into(binding.detailsImageView);
    }
}