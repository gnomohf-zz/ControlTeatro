package com.example.teatro;

public class Comando {
	
	private char comandoId;
	private char velocidad;
	private char direccion;
	
	
	
	public Comando()
	{
		comandoId=0;
		velocidad=0;
		direccion=0;
	}
	
	public Comando(char x,char y, char z)
	{
		comandoId=x;
		velocidad=y;
		direccion=z;
	}

	public char getComandoId() {
		return comandoId;
	}

	public void setComandoId(char comando) {
		this.comandoId = comando;
	}

	public char getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(char velocidad) {
		this.velocidad = velocidad;
	}

	public char getDireccion() {
		return direccion;
	}

	public void setDireccion(char direccion) {
		this.direccion = direccion;
	}

	
	
	
}
