package com.motioncoding.miband;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.motioncoding.miband.model.LeParams;

public class MiLeParamsActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();
		
		LeParams params = (LeParams) getIntent().getParcelableExtra("params");
		
		String[] values = new String[6];
		
		values[0] = String.format("Connection Intervall\n%s ms", params.connInt);
		values[1] = String.format("Connection Intervall Min\n%s ms", params.connIntMin);
		values[2] = String.format("Connection Intervall Max\n%s ms", params.connIntMax);
		
		values[3] = String.format("Advertising Intervall\n%s ms", params.advInt);
		values[4] = String.format("Latency\n%s ms", params.latency);
		values[5] = String.format("Timeout\n%s ms", params.timeout);
		
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        android.R.layout.simple_list_item_1, values);
		this.setListAdapter(adapter);
	}
}
