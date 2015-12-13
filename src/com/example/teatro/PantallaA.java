package com.example.teatro;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import comandos.*;


@SuppressLint("NewApi")
public class PantallaA extends ActionBarActivity {
	
	
	
	//socket y outputstream que uso para mandar datos
	private BluetoothSocket btsocket;
	private OutputStream out;
	
	//
	private ArrayList<Comando> acto; //ArrayList de los comandos
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pantalla);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pantalla, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

////A partir de aca lo que copio de agustin de onResume y onPause que me 

public static class PlaceholderFragment extends Fragment {

	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_pantalla, container, false);
		return rootView;
	}
}


protected void onResume(){
	super.onResume();

	
	
	
	
	
}


protected void onPause(){
	super.onPause();

	
	
	
	
	
}


/////BOTONES


public void buttonMotor(View v)
{
	//Por ahora deberia llamar a una activity para cargar los datos del motor 
	Intent act = new Intent(this, PantallaMotor.class);
    startActivity(act);
	
	
}

public void buttonLuz(View v)
{
	Intent act = new Intent(this, PantallaLuz.class);
    startActivity(act);
}




public void volverAnterior(View v){
	
	finish();
}

}






