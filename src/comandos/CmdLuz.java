package comandos;

public class CmdLuz implements Comando {
	
	private byte comandoId;
	private byte nmotor;
	private byte velocidad;
	private byte direccion;
	private byte pasos;
	

	public CmdLuz()
	{
		this.comandoId=0;
		this.velocidad=0;
		this.nmotor=0;
		this.direccion=0;
		this.pasos=0;
	}
	
	public CmdLuz(char velocidad, char direccion, char pasos) {
		this.setComandoId((byte)0x30);
		this.velocidad = (byte)velocidad;
		this.direccion = (byte)direccion;
		this.pasos = (byte)pasos;
	}
	
	
	@Override
	public byte[] getComando() {
		// TODO Auto-generated method stub
		return null;
	}

	public byte getComandoId() {
		return comandoId;
	}

	public void setComandoId(byte comandoId) {
		this.comandoId = comandoId;
	}

}
