 package com.aplicativo.topijava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.aplicativo.topijava.adapter.UsuarioAdapter;
import com.aplicativo.topijava.viewmodel.MainViewModel;
import dagger.hilt.android.AndroidEntryPoint;

 @AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
     private UsuarioAdapter usuarioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        initViewModel();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rvUsuarios);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        usuarioAdapter = new UsuarioAdapter();
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