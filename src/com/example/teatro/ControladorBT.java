package com.example.teatro;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import android.R.string;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class ControladorBT{

	private BluetoothAdapter bAdapter;
	private Context contexto;
	private BluetoothSocket btsocket;
	private static final UUID my_uuid=UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
	private OutputStream out;
	
	public ControladorBT(Context context) {
		// TODO Auto-generated constructor stub
		bAdapter = BluetoothAdapter.getDefaultAdapter();
		this.contexto = context;
	}
	
	public boolean btOn(){
		if(bAdapter.isEnabled()){
			return true;
		}else{
			return bAdapter.enable();
		}
	}
	
	public boolean btOff(){
		try {
			btsocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bAdapter.disable();
	}
	
	public BluetoothDevice isPaired(String Name){
		BluetoothDevice z = null;
		Set <BluetoothDevice> AL;
		
		AL = bAdapter.getBondedDevices();
		
		if(AL.size() > 0){
			for(BluetoothDevice device : AL){
				if(device.getName().equals(Name)) z = device;
			}
		}
		//BluetoothDevice
		//BluetoothDevice
		return z;
	}
	
	public void Conectar(BluetoothDevice bt)
	{
		
		
		try {
			
			btsocket= bt.createRfcommSocketToServiceRecord(my_uuid);
			
			btsocket.connect();
			out = btsocket.getOutputStream();
			String a= "hola";
			out.write(a.getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void Enviar(String dato)
	{
		try {
			
			out.write(dato.getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
