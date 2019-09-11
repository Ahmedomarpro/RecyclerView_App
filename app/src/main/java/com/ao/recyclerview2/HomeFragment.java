package com.ao.recyclerview2;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

	ImageView btFavorite,btAccount;
	ImageButton btHome;

	RecyclerView rvArticle;
	AdapterArticles madapter;

	String articles [] = {"WELCOME NEW ","rvArticle","rvArticle"};

	public HomeFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.fragment_home, container, false);




		rvArticle   = v.findViewById(R.id.rvArticles);
		rvArticle.setHasFixedSize(true);
		final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
		rvArticle.setLayoutManager(layoutManager);

		ArrayList<String> dataArticles = new ArrayList<>();

		for (int i=0; i<50; ++i){
			dataArticles.add("ADELE ");
		}

		dataArticles.add(articles[0]);
		dataArticles.add(articles[1]);
		dataArticles.add(articles[2]);

		madapter = new AdapterArticles(dataArticles, getActivity());
		rvArticle.setAdapter(madapter);
		rvArticle.setPadding(130,110,130,100);

		final SnapHelper snapHelper = new LinearSnapHelper();
		snapHelper.attachToRecyclerView(rvArticle);

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				RecyclerView.ViewHolder viewHolder = rvArticle.findViewHolderForAdapterPosition(0);
				RelativeLayout rl1 = viewHolder.itemView.findViewById(R.id.rl1);
				rl1.animate().scaleY(1).scaleX(1).setDuration(350).setInterpolator(new AccelerateInterpolator()).start();
			}
		},100);


		rvArticle.addOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
				super.onScrollStateChanged(recyclerView, newState);

				View v = snapHelper.findSnapView(layoutManager);
				int pos = layoutManager.getPosition(v);

				RecyclerView.ViewHolder viewHolder = rvArticle.findViewHolderForAdapterPosition(pos);
				RelativeLayout rl1 = viewHolder.itemView.findViewById(R.id.rl1);

				if (newState == RecyclerView.SCROLL_STATE_IDLE){
					rl1.animate().setDuration(350).scaleX(1).scaleY(1).setInterpolator(new AccelerateInterpolator()).start();
				}else{
					rl1.animate().setDuration(350).scaleX(0.70f).scaleY(0.65f).setInterpolator(new AccelerateInterpolator()).start();
				}

			}

			@Override
			public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
				super.onScrolled(recyclerView, dx, dy);
			}
		});



















		return v;
	}

}
