package comandos;

public class CmdMotor implements Comando {
	
	private byte comandoId;
	private byte nmotor;
	private byte velocidad;
	private byte direccion;
	private int pasos;
	
	
	public CmdMotor()
	{
		
	}
	
	public CmdMotor(char velocidad, char direccion, int pasos) {
		
		this.comandoId = (byte)0x30;
		this.velocidad = (byte)velocidad;
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
	public byte[] getComando() {
		// TODO Auto-generated method stub
		
		
		
		
		return null;
	}


	
	
	
	

}