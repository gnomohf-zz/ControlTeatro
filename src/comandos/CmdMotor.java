package comandos;

import java.io.IOException;
import java.io.OutputStream;

import android.content.Context;
import android.widget.Toast;

public class CmdMotor implements Comando {
	
	private byte comandoId;
	private byte nmotor;
	private byte velocidad;
	private byte direccion;
	private int pasos;
	
	private Context CONTEXTO;
	
	public CmdMotor()
	{
		this.comandoId=(byte)0x30;;
		this.nmotor=0;
		this.velocidad=0;
		this.direccion=0;
		this.pasos=0;
		
	}
	
	public CmdMotor(char nmotor,char velocidad, char direccion, int pasos) {
		
		this.comandoId = (byte)0x30;
		this.velocidad = (byte)velocidad;
		this.nmotor=(byte)nmotor;
		this.direccion = (byte)direccion;
		this.pasos = pasos;
	}


	public byte getComandoId() {
		return comandoId;
	}


	public void setComandoId(char comandoId) {
		this.comandoId = (byte)comandoId;
	}


	public char getVelocidad() {
		return (char) velocidad;
	}


	public void setVelocidad(char velocidad) {
		this.velocidad = (byte)velocidad;
	}


	public char getDireccion() {
		return (char) direccion;
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
	
	public char getNmotor() {
		return (char)nmotor;
	}


	public void setNmotor(byte nmotor) {
		this.nmotor = nmotor;
	}
	
	public void setContext(Context contexto){
		CONTEXTO = contexto;
	}


	@Override
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
			
			buffer[0]=comandoId;
			buffer[1]=nmotor;
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