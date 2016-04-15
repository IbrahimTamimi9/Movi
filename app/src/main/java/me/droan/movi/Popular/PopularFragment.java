package me.droan.movi.popular;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import me.droan.movi.MoviFragment;

/**
 * Created by drone on 15/04/16.
 */
public class PopularFragment extends MoviFragment {

  public static PopularFragment newInstance() {
    Bundle args = new Bundle();
    PopularFragment fragment = new PopularFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void initViews() {
  }

  @Override public RecyclerView.Adapter getAdapter() {
    return new PopularAdapter(getActivity());
  }

  @Override public int getFancyGridType() {
    return WITH_HEADER_FANCY_TYPE;
  }
}

