package com.example.teatro;

public class CmdMotor extends Comando {
	
	private int pasos;
	
	public CmdMotor(){
		
		super();
		setPasos(0);
		
		
		
		super.setComandoId((byte)0x30);
		
		
	}
	
	public CmdMotor(char velocidad, char direccion, int pasos)
	{
		
		super.setComandoId((byte)0x30);
		super.setDireccion(direccion);
		super.setVelocidad(velocidad);
		this.setPasos(pasos);
	}

	public int getPasos() {
		return pasos;
	}

	public void setPasos(int pasos) {
		this.pasos = pasos;
	}
	

}