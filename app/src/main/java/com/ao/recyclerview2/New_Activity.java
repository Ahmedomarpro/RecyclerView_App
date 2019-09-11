package com.ao.recyclerview2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class New_Activity extends AppCompatActivity {

	private TextView mTextView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_);

		mTextView1 = findViewById(R.id.text_view1);

		String Nsave = "null";

		if (getIntent().hasExtra("Key")) {

			  Nsave = getIntent().getStringExtra("Key");

		}

		mTextView1.setText(Nsave);


		}
	}
