package com.ao.recyclerview2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterArticles extends RecyclerView.Adapter<AdapterArticles.ViewHolder> {

	ArrayList<String> list = new ArrayList<>();
	Context context;

	public AdapterArticles(ArrayList<String> list, Context context) {
		this.list = list;
		this.context = context;
	}




	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_articles_recyc, parent,false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
		holder.tvTitle.setText(list.get(position));
		holder.tvTitle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(context, "Welcom Ahmed"+getItemId(position), Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(context,New_Activity.class);

				intent.putExtra("Key",list.get(position));
				context.startActivity(intent);
			}
		});
	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		public ImageView imgArticle;
		public TextView tvTitle,tvDesc;
		public Button btReadMore;
		public	RelativeLayout r11;
		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			imgArticle  = itemView.findViewById(R.id.imgArticle);
			tvTitle     = itemView.findViewById(R.id.tvTitle);
			tvDesc      = itemView.findViewById(R.id.tvDesc);
			btReadMore  = itemView.findViewById(R.id.btReadMore);
					r11 = itemView.findViewById(R.id.rl1);

		}
	}
}
