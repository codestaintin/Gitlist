package com.example.isioyemohammed.gitlist.service;

import com.example.isioyemohammed.gitlist.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by isioyemohammed on 13/03/2018.
 */

public interface GithubAPI {
    /**
     * getItems method for getting JSON data from server.
     * @return json data from API
     */
    @GET("search/users?q=language:java+location:nairobi")
    Call<GithubUsersResponse> getItems();
}
