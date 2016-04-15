package me.droan.movi.upcomingTop;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import me.droan.movi.MoviFragment;

/**
 * Created by drone on 15/04/16.
 */
public class UpcomingFragment extends MoviFragment {
  public static UpcomingFragment newInstance() {
    Bundle args = new Bundle();
    UpcomingFragment fragment = new UpcomingFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void initViews() {

  }

  @Override public RecyclerView.Adapter getAdapter() {
    return new CommonUpcomingTopAdapter(getActivity());
  }

  @Override public int getFancyGridType() {
    return SIMPLE_FANCY_TYPE;
  }
}
