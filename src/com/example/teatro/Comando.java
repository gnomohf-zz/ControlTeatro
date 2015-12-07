package com.example.teatro;

public class Comando {
	
	private byte comandoId;
	private byte velocidad;
	private byte direccion;
	
	
	
	public Comando()
	{
		comandoId=0;
		velocidad=0;
		direccion=0;
	}
	
	public Comando(char x,char y, char z)
	{
		comandoId=(byte)x;
		velocidad=(byte)y;
		direccion=(byte)z;
	}

	public byte getComandoId() {
		return comandoId;
	}

	public void setComandoId(byte comando) {
		this.comandoId = (byte)comando;
	}

	public char getVelocidad() {
		return (char)velocidad;
	}

	public void setVelocidad(char velocidad) {
		this.velocidad = (byte)velocidad;
	}

	public char getDireccion() {
		return (char)direccion;
	}

	public void setDireccion(char direccion) {
		this.direccion = (byte)direccion;
	}

	
	
	
}
