package com.example.teatro;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;

import java.io.IOException;
import java.io.OutputStream;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import comandos.Comando;


@SuppressLint("NewApi")
public class PantallaMotor extends ActionBarActivity {
	
	private Comando comando;
	private EditText nmotor;
	private EditText velocidad;
	private EditText direccion;
	private EditText pasos;
	
	private BluetoothSocket btsocket;
	private OutputStream out;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pantalla_motor);
		
		///Me agarro la referencia a parametros de la actividad
		
		nmotor = (EditText) findViewById(R.id.editnmotor);
		velocidad = (EditText) findViewById(R.id.editvmotor);
		direccion = (EditText) findViewById(R.id.editdmotor);
		pasos = (EditText) findViewById(R.id.editpmotor);
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pantalla_motor, menu);
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




/////BOTONES

private byte Short_To_Byte(short a){
	byte z = 0;
	
	z = (byte) (a & 0xFF);
	
	if((a & 0x80) == 0x80) z = (byte) (z | 0x80);
	
	return z;
}

public void enviacmdMotor(View v)
{
	comando = new Comando();
	
	
	//Tengo toda la data del comando al motor
	
	comando.setContext(this.getApplicationContext());
	
	comando.setNumero((char)Integer.parseInt(nmotor.getText().toString()));
	comando.setVelocidad((char)Integer.parseInt(velocidad.getText().toString()));
	
	comando.setDireccion((char)Integer.parseInt((direccion.getText().toString())));
	
	
	comando.setPasos(Integer.parseInt(pasos.getText().toString()));
	
	
	//Toast.makeText(this.getApplicationContext(), Integer.toString((short)Integer.parseInt(nmotor.getText().toString())), Toast.LENGTH_SHORT).show();

	btsocket = ControladorBT.getSocket();
	
	try {
		out = btsocket.getOutputStream();
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

		

	
	comando.enviaComando(out);
	
	
}
public void cargarEnActo(View v)
{
	
	//Creo el comando y cargo todo
	comando = new Comando();
	
	
	//Tengo toda la data del comando al motor
	
	//comando.setContext(this.getApplicationContext());
	comando.setComandoid((byte) 0x30);
	comando.setNumero((char)Integer.parseInt(nmotor.getText().toString()));
	comando.setVelocidad((char)Integer.parseInt(velocidad.getText().toString()));
	
	comando.setDireccion((char)Integer.parseInt((direccion.getText().toString())));
	
	
	comando.setPasos(Integer.parseInt(pasos.getText().toString()));
	
	
	
	
	//Deberia devolver los datos a la instancia de pantallaA
	
	//int cod_resultado = 1;
	
	Intent resultado = new Intent();
	resultado.putExtra("devolucion_motor", comando);
	setResult(Activity.RESULT_OK, resultado);
	
	this.finish();	
	
}



public void volverAnterior(View v){
	
	finish();
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
