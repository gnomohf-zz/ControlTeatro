package com.example.teatro;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;

import java.io.IOException;
import java.io.OutputStream;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import comandos.CmdLuz;

@SuppressLint("NewApi")
public class PantallaLuz extends ActionBarActivity {
	
	
	
	private CmdLuz comando;
	private EditText nluz;
	private EditText velocidad;
	private EditText direccion;
	private EditText pasos;
	
	private BluetoothSocket btsocket;
	private OutputStream out;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pantalla_luz);
		
		nluz = (EditText) findViewById(R.id.editnluz);
		velocidad = (EditText) findViewById(R.id.editvluz);
		direccion = (EditText) findViewById(R.id.editdluz);
		pasos = (EditText) findViewById(R.id.editpluz);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pantalla_luz, menu);
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
	
	
	protected void onResume(){
		super.onResume();

		
		
		
		
		
	}


	protected void onPause(){
		super.onPause();

		
		
		
		
		
	}

	
	
	public void enviacmdLuz(View v)
	{
		comando = new CmdLuz();
		
		
		//Tengo toda la data del comando al motor
		comando.setNluz((char)Integer.parseInt(nluz.getText().toString()));
		comando.setVelocidad((char)Integer.parseInt(velocidad.getText().toString()));
		comando.setDireccion((char)Integer.parseInt((direccion.getText().toString())));
		comando.setPasos((char)Integer.parseInt(pasos.getText().toString()));
		

		btsocket = ControladorBT.getSocket();
		
		try {
			out = btsocket.getOutputStream();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		comando.enviaComando(out);
		
		
	}

		
	public void cargarEnActo()
	{
		//veremos que hace mas adelante
	}
		
		
		
		
		//NO SE QUE HACE  PERO LO PUSO AGUS///
		public static class PlaceholderFragment extends Fragment {

			public PlaceholderFragment() {
			}

			
			@Override
			public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
				View rootView = inflater.inflate(R.layout.activity_pantalla, container, false);
				return rootView;
			}
		}
		
		
	}

	
	
	

