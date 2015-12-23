package comandos;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

import android.content.Context;
import android.widget.Toast;

public class Comando implements Serializable {
	
	private byte comandoid;
	private byte numero;
	private byte velocidad;
	private byte direccion;
	private int pasos;
	
	private Context CONTEXTO;
	
	public Comando()
	{
		this.comandoid=(byte)0x30;;
		this.numero=0;
		this.velocidad=0;
		this.direccion=0;
		this.pasos=0;
		
	}
	
	public Comando(byte comandoid,char nmotor,char velocidad, char direccion, int pasos) {
		
		this.comandoid = (byte)comandoid;
		this.velocidad = (byte)velocidad;
		this.numero=(byte)nmotor;
		this.direccion = (byte)direccion;
		this.pasos = pasos;
	}


	public byte getComandoid() {
		return comandoid;
	}


	public void setComandoid(byte comandoId) {
		this.comandoid = comandoId;
	}


	public byte getVelocidad() {
		return  velocidad;
	}


	public void setVelocidad(char velocidad) {
		this.velocidad = (byte)velocidad;
	}


	public byte getDireccion() {
		return direccion;
	}


	public void setDireccion(char direccion) {
		this.direccion = (byte) direccion;
	}


	public int getPasos() {
		return (int)pasos;
	}


	public void setPasos(int pasos) {
		
		
		this.pasos = pasos;
	}
	
	public byte getNumero() {
		return numero;
	}


	public void setNumero(char nmotor) {
		this.numero = (byte)nmotor;
	}



	public void setContext(Context cONTEXTO) {
		CONTEXTO = cONTEXTO;
	}

	public void enviaComando(OutputStream out) {
		// TODO Auto-generated method stub
		
		try {
			///Envio dato por dato
			/*out.write(comandoId);
			out.write(nmotor);
			out.write(velocidad);
			out.write(direccion);
			*/
			
			//dividiendo pasos x byte
			int a;
			int b;
			int c;
			int d;
			
			d = (byte) (pasos & 0xff);
			
			c = (byte) ((pasos & 0xff00) >> 8);
			
			b = (byte) ((pasos & 0xff0000) >> 16);
			
			a = (byte) ((pasos & 0xff000000) >> 24);
			//a = (byte) pasos >> 24;
			//////
			
			//Toast.makeText(CONTEXTO, Integer.toString(c), Toast.LENGTH_SHORT).show();
			
			byte[] buffer;
			
			buffer = new byte[8];
			
			buffer[0]=comandoid;
			buffer[1]=numero;
			buffer[2]=velocidad;
			buffer[3]=direccion;
			buffer[4]=(byte)a;
			buffer[5]=(byte)b;
			buffer[6]=(byte)c;
			buffer[7]=(byte)d;
			
			out.write(buffer);
			
			
			

			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	
	
	
	

}