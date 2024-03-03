package com.aplicativo.topijava.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.aplicativo.topijava.databinding.ActivityRepoDetailsBinding;
import com.aplicativo.topijava.model.Data;
import com.aplicativo.topijava.model.Owner;
import com.bumptech.glide.Glide;

public class RepoDetailsActivity extends AppCompatActivity {

    private ActivityRepoDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityRepoDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        updateView();
    }

    private void updateView(){
        Intent intent = getIntent();
        if (intent.getParcelableExtra("repo") != null) {
            Data repo = (Data) getIntent().getParcelableExtra("repo");
            Data data = repo;

            binding.tvFullname.setText(data.getFull_name());
            binding.tvRepoName.setText(data.getName());
            binding.tvRepoDescription.setText(data.getDescription());
            binding.tvFork.setText(data.getForsk());
            binding.tvStar.setText(data.getStargazers_count());

            if (intent.getParcelableExtra("imgProfile") != null) {
                Owner profile = (Owner) getIntent().getParcelableExtra("imgProfile");
                Owner image = profile;
                Glide.with(binding.imgProfile)
                        .load(profile.getAvatar_url())
                        .into(binding.imgProfile);
            }
        }
    }
}