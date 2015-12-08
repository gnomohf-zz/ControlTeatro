package comandos;

import java.io.IOException;
import java.io.OutputStream;

public class CmdLuz implements Comando {
	
	private byte comandoId;
	private byte nluz;
	private byte velocidad;
	private byte direccion;
	private byte pasos;
	

	public CmdLuz()
	{
		this.comandoId=0;
		this.nluz=0;
		this.velocidad=0;
		this.direccion=0;
		this.pasos=0;
	}
	
	public CmdLuz(char velocidad,char nluz, char direccion, char pasos) {
		this.comandoId= (byte)0x30;
		this.nluz=(byte)nluz;
		this.velocidad = (byte)velocidad;
		this.direccion = (byte)direccion;
		this.pasos = (byte)pasos;
	}
	
	
	public byte getComandoId() {
		return comandoId;
	}

	public void setComandoId(char comandoId) {
		this.comandoId = (byte)comandoId;
	}

	public char getNluz() {
		return (char)nluz;
	}

	public void setNluz(char nluz) {
		this.nluz = (byte)nluz;
	}

	public char getVelocidad() {
		return (char)velocidad;
	}

	public void setVelocidad(char velocidad) { 
		this.velocidad =(byte) velocidad;
	}

	public char getDireccion() {
		return (char)direccion;
	}

	public void setDireccion(char direccion) {
		this.direccion = (byte)direccion;
	}

	public char getPasos() {
		return (char)pasos;
	}

	public void setPasos(char pasos) {
		this.pasos = (byte)pasos;
	}
	
	@Override
	public void enviaComando(OutputStream out) {
		// TODO Auto-generated method stub
		
		try {
			out.write(comandoId);
			out.write(nluz);
			out.write(velocidad);
			out.write(direccion);
			out.write(pasos);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
