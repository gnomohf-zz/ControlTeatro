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
import android.widget.EditText;
import android.widget.Toast;
import comandos.*;
import sqlite.Handler_db;


@SuppressLint("NewApi")
public class PantallaA extends ActionBarActivity {
	
	
	
	//socket y outputstream que uso para mandar datos
	private BluetoothSocket btsocket;
	private OutputStream out;
	
	
	//
	private EditText nombreacto;
	
	Handler_db handler = new Handler_db(this);
	
	//
	private ArrayList<Comando> acto; //ArrayList de los comandos
	public final static int REQ_MOTOR = 1;
	public final static int REQ_LUZ=2;
	private String nomacto;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pantalla);
		
		
		this.nombreacto = (EditText) findViewById(R.id.editnombreacto);
		
		this.handler = new Handler_db(this);
		
		
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
	startActivityForResult(act, REQ_MOTOR); 
	
	
}

public void buttonLuz(View v)
{
	Intent act = new Intent(this, PantallaLuz.class);
    startActivityForResult(act,REQ_LUZ);
    
    
}


protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	Comando comando = new Comando();
	
	if(requestCode == REQ_MOTOR) {
        comando = (Comando) data.getExtras().getSerializable("devolucion_motor");
    }
	if(requestCode == REQ_LUZ)
	{
		comando = (Comando) data.getExtras().getSerializable("devolucion_luz");
	}

    this.acto.add(comando);
}





public void buttonCargarActo(View v)
{
	
	
	nomacto = new String();
	
	nomacto = this.nombreacto.getText().toString();
	
	
	/*
	//Cargo nombre de acto //Se debe sacar de un edittext
	if(handler.getActoid(nomacto) == 0)//Si no existe un acto con el mismo nombre
	{
		handler.creaActo(nomacto); //creo el acto
	}
	else{
		Toast.makeText(this, "Ya hay un acto con ese nombre", Toast.LENGTH_LONG).show();
	}
	*/
	
	
	
	
	/*
	//inserta comandos en tabla comandos - Debo obtener la id del acto creado
	
	int actoid = handler.getActoid(nomacto);//Saco la id 
	
	for (Comando cmd : acto) {
		
			boolean insertado = handler.cargaComando((int)cmd.getComandoid(),Byte.toString(cmd.getNumero()),Byte.toString(cmd.getVelocidad()),Byte.toString(cmd.getDireccion()), Integer.toString(cmd.getPasos()), actoid);
			
			if(insertado == true)
			{
				Toast.makeText(this, "Se inserto dato correctamente...", Toast.LENGTH_LONG).show();
			}
			else
			{
				Toast.makeText(this, "No se pudo insertar dato", Toast.LENGTH_LONG).show();
			}
		
	}
	*/
	
}


public void volverAnterior(View v){
	
	finish();
}

}






