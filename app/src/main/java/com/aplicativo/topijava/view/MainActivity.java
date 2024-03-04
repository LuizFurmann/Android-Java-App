 package com.aplicativo.topijava.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.aplicativo.topijava.PowerReceiver;
import com.aplicativo.topijava.R;
import com.aplicativo.topijava.databinding.ActivityMainBinding;
import com.aplicativo.topijava.viewmodel.MainViewModel;
import dagger.hilt.android.AndroidEntryPoint;

 @AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
     private UsuarioAdapter usuarioAdapter;
     private ActivityMainBinding binding;

     private PowerReceiver powerReceiver = new PowerReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);

        registerReceiver(powerReceiver, intentFilter);

        setTitle("");
        initRecyclerView();
        initViewModel();
    }

     @Override
     protected void onDestroy() {
         super.onDestroy();
         unregisterReceiver(powerReceiver);
     }

     private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rvUsuarios);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        usuarioAdapter = new UsuarioAdapter();
        usuarioAdapter.context = this;
        recyclerView.setAdapter(usuarioAdapter);
    }

    private void initViewModel(){
        MainViewModel viewModel = new ViewModelProvider(this).get(
            MainViewModel.class);
        viewModel.getLiveData().observe(this, data -> {
            if(data != null){
                usuarioAdapter.setListItems(data);
                usuarioAdapter.notifyDataSetChanged();
            }else{
                Toast.makeText(MainActivity.this, "Something is wrong with connection!", Toast.LENGTH_SHORT).show();
            }
        });
        viewModel.Apicall();
    }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu, menu);
         MenuItem search = menu.findItem(R.id.search);
         SearchView searchView = (SearchView) search.getActionView();

         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
             @Override
             public boolean onQueryTextSubmit(String query) {
                 return false;
             }

             @Override
             public boolean onQueryTextChange(String newText) {
                 usuarioAdapter.getFilter().filter(newText);
                 return false;
             }
         });
         return super .onCreateOptionsMenu(menu);
     }
 }