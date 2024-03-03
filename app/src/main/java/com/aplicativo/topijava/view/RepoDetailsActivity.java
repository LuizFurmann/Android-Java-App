package com.aplicativo.topijava.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.aplicativo.topijava.R;
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
        setupToolbar();

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
                finish();
                return true;
        }
    }

    private void setupToolbar() {
        setTitle("");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}