package comandos;

import java.io.IOException;
import java.io.OutputStream;

public class CmdMotor implements Comando {
	
	private byte comandoId;
	private byte nmotor;
	private byte velocidad;
	private byte direccion;
	private int pasos;
	
	
	public CmdMotor()
	{
		this.comandoId=(byte)0x30;;
		this.nmotor=0;
		this.velocidad=0;
		this.direccion=0;
		this.pasos=0;
		
	}
	
	public CmdMotor(char velocidad,char nmotor, char direccion, int pasos) {
		
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
		return pasos;
	}


	public void setPasos(int pasos) {
		this.pasos = pasos;
	}
	
	public byte getNmotor() {
		return nmotor;
	}


	public void setNmotor(byte nmotor) {
		this.nmotor = nmotor;
	}


	@Override
	public void enviaComando(OutputStream out) {
		// TODO Auto-generated method stub
		
		try {
			///Envio dato por dato
			out.write(comandoId);
			out.write(nmotor);
			out.write(velocidad);
			out.write(direccion);
			
			//dividiendo pasos x byte
			int a;
			int b;
			int c;
			int d;
			
			d = pasos & 0xff;
			
			c = pasos & 0xff00;
			c = c / 100;
			
			b = pasos & 0xff0000;
			b = b / 10000;
			
			a = pasos / 1000000;
			
			out.write(a);
			out.write(b);
			out.write(c);
			out.write(d);
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	
	
	
	

}