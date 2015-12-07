package com.example.teatro;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
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
import android.widget.TextView;
import android.widget.Toast;


@SuppressWarnings("deprecation")
@SuppressLint("NewApi")
public class Main extends ActionBarActivity {
	
	private Button buttonConnect;
	private Button buttonSend;
	private BluetoothDevice device;
	private ControladorBT blth;
	private TextView texto;
	private EditText mensaje;
	private int i;
	private String numero;
	

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

	//hola
	
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
	
	


public static class PlaceholderFragment extends Fragment {

	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.main, container, false);
		return rootView;
	}
}

protected void onResume(){
	super.onResume();

	blth = new ControladorBT(getApplicationContext());
	
	texto = (TextView) findViewById(R.id.textView1);
	
	i = 0;
	buttonConnect = (Button) findViewById(R.id.buttonConnect);
	buttonSend = (Button) findViewById(R.id.buttonSend);
	
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
			
			i++;
			
			numero= Integer.toString(i);
			
			texto.setText(numero);
		}
	});
	
	buttonSend.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			if(device != null)
			{
				i++;
				
				//numero= Integer.toString(i);
				
				mensaje = (EditText) findViewById(R.id.fieldMsj);///Luego usar el tipo de dato que sea necesario
				
				
				
				
				blth.Enviar(mensaje.getText().toString());
				
				
				
			}
			
			
		}
	});
	
	
	
}

protected void onPause(){
	super.onPause();
	blth.btOff();
	finish();//Toast.makeText(getApplicationContext(), "Dispositivo Encontrado", Toast.LENGTH_SHORT).show();
//}else{
}

private void Show_Error(String Texto){
	Toast.makeText(getBaseContext(), Texto, Toast.LENGTH_LONG).show();
	this.onPause();
}
}