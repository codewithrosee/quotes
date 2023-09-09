package com.practice.quotes;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvQuotes;
    ProgressBar pbQuotes;
    QuotesAdapter quotesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvQuotes = findViewById(R.id.rvQuotes);
        pbQuotes = findViewById(R.id.pbQuotes);


        QuoteService service = RetrofitClient.getRetrofitInstance().create(QuoteService.class);
        service.getQuotes().enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                pbQuotes.setVisibility(View.GONE);
                quotesAdapter = new QuotesAdapter(response.body());
                rvQuotes.setAdapter(quotesAdapter);
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                pbQuotes.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

    }
}