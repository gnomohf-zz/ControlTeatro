package com.example.teatro;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class Listener extends Thread {
	
	
	private InputStream in;
	private BluetoothSocket btsocket;
	private byte[] buffer;
	private String mensaje;
	private TextView pizarron;
	private Context contexto;
	
	public Listener(Context context, BluetoothSocket socket, TextView tx)
	{
		btsocket = socket;
		contexto=context;
		pizarron=tx;
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			
			
			
			in = btsocket.getInputStream();
			
			in.read(buffer);
			
			mensaje = buffer.toString();
			
			pizarron.setText(mensaje);
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
