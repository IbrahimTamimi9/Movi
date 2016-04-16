package me.droan.movi.upcomingTop;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.ArrayList;
import me.droan.movi.MoviFragment;
import me.droan.movi.MoviServices;
import me.droan.movi.MovieListModel.MovieList;
import me.droan.movi.MovieListModel.Result;
import me.droan.movi.utils.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by drone on 15/04/16.
 */
public class TopFragment extends MoviFragment {
  private static final String TAG = "TopFragment";
  MoviServices services;
  ArrayList<Result> list = new ArrayList<>();

  public static TopFragment newInstance() {
    Bundle args = new Bundle();
    TopFragment fragment = new TopFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void initViews() {

  }

  @Override public RecyclerView.Adapter getAdapter() {
    return new CommonUpcomingTopAdapter(getActivity(), list);
  }

  @Override public int getFancyGridType() {
    return SIMPLE_FANCY_TYPE;
  }

  private void initRetrofit() {

    services = RetrofitHelper.getRetrofitObj().create((MoviServices.class));
    serviceHandler();
  }

  private void serviceHandler() {
    Call<MovieList> call;
    call = services.getTopRatedMovies();

    call.enqueue(new Callback<MovieList>() {
      @Override public void onResponse(Call<MovieList> call, Response<MovieList> response) {
        Log.d(TAG,
            "onResponse() called with: " + "call = [" + call + "], response = [" + response + "]");
        MovieList movieList = response.body();
        list = (ArrayList<Result>) movieList.results;
        new Handler().postDelayed(new Runnable() {
          @Override public void run() {
            recyclerView.setAdapter(new CommonUpcomingTopAdapter(getActivity(), list));
          }
        }, 200);
      }

      @Override public void onFailure(Call<MovieList> call, Throwable t) {
        Log.d(TAG, "onFailure() called with: " + "call = [" + call + "], t = [" + t + "]");
      }
    });
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initRetrofit();
  }
}