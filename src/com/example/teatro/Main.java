package com.example.teatro;

import java.io.OutputStream;

import android.R.integer;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HeterogeneousExpandableList;
import android.widget.TextView;
import android.widget.Toast;


@SuppressWarnings("deprecation")
@SuppressLint("NewApi")
public class Main extends ActionBarActivity {
	
	private Button buttonConnect;
	private Button buttonIngresar;
	private BluetoothDevice device;
	private BluetoothSocket btsocket;
	private ControladorBT blth;
	private TextView texto;//Texto arriba de la pantalla principal
	
	
	
	///Variables de prueba
	private EditText mensaje;///No se usa, estaba de prueba
	private int i;//De prueba
	private String numero;//De prueba
	
////Fin de la definicion de atributos
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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


	protected void onStart()
	{
		device=null;
		
		super.onStart();
		if(blth == null)
		{
			blth = new ControladorBT(getApplicationContext());
		}
		else
		{
			Toast.makeText(getApplicationContext(), "Bluetooth ya inicializado(desde onResume)", Toast.LENGTH_SHORT).show();
		}
		
	}

	protected void onResume(){
	super.onResume();
//Aca comienzo
	
	if(blth == null)
	{
		blth = new ControladorBT(getApplicationContext());
	}
	else
	{
		Toast.makeText(getApplicationContext(), "Bluetooth ya inicializado(desde onResume)", Toast.LENGTH_SHORT).show();
	}
	

	/*buttonConnect = (Button) findViewById(R.id.buttonConnect);//Referencia al boton de conectar bluetooth
	
	
	
	//Listener del boton Conectar Bluetooth
	buttonConnect.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		
			
			if(!blth.btOn())Show_Error("Error al iniciar el BlueTooth");
			
			 device = blth.isPaired("Agus87BT");
			
			if(device != null){
				Toast.makeText(getApplicationContext(), "Dispositivo Encontrado", Toast.LENGTH_SHORT).show();
				blth.Conectar(device);
				
				
			}else{
				Toast.makeText(getApplicationContext(), "Dispositivo no Encontrado", Toast.LENGTH_SHORT).show();
			}
			
		}
	});*/
	
	/*
	buttonIngresar = (Button) findViewById(R.id.buttonIngresar);//Referencia al boton "Ingresar"
	//Listener del Boton "Ingresar" ///Me debe llevar a la pantalla de configuracion
	buttonIngresar.setOnClickListener(new OnClickListener() {
	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			//Context context = null;
			//Aca deberia enviarnos a la pantalla para empezar a realizar la creacion de los comandos
			Intent act = new Intent(, PantallaA.class);
		    startActivity(act);
			
			/*if(device != null)
			{
				
				
			}
			else {
				Toast.makeText(getApplicationContext(), "Debe conectarse al dispositivo", Toast.LENGTH_SHORT).show();
			}*/
			
			
	//	}
//	});
	
}


public void conectarBluetooth(View v){
	
	if(!blth.btOn())Show_Error("Error al iniciar el BlueTooth");
	
	 device = blth.isPaired("Agus87BT");
	
	if(device != null){
		Toast.makeText(getApplicationContext(), "Dispositivo Encontrado", Toast.LENGTH_SHORT).show();
		blth.Conectar(device);
		
		
	}else{
		Toast.makeText(getApplicationContext(), "Dispositivo no Encontrado", Toast.LENGTH_SHORT).show();
	}
	
	
}

public void ingresaraPantallaA(View v){
	
	if(device !=null)
	{
	Intent act = new Intent(this, PantallaA.class);
	startActivity(act);	
	
    
	}
	else
	{
		Toast.makeText(getApplicationContext(), "Debe conectarse al dispositivo", Toast.LENGTH_SHORT).show();
	}
	
	}
	

protected void onPause(){
	super.onPause();
	
}



protected void onDestroy()
{
	//blth.btOff();
}

private void Show_Error(String Texto){
	Toast.makeText(getBaseContext(), Texto, Toast.LENGTH_LONG).show();
	this.onPause();
}

public static class PlaceholderFragment extends Fragment {

	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.main, container, false);
		return rootView;
	}
}
}