package com.practice.quotes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuoteService {

    @GET("quotes")
    Call<List<Quote>> getQuotes();

}
