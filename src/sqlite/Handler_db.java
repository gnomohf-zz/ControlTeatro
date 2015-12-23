package sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.cert.LDAPCertStoreParameters;

//import static android.provider.BaseColumns._ID;

import android.content.ContentValues;
import android.content.Context;

public class Handler_db extends SQLiteOpenHelper{
	
	public static final String DB_NAME = "teatro.db";
	public static final String TABLE_1_NAME = "acto";
	public static final String TABLE_2_NAME = "comando";
	
	public static final String T1C1 = "_ID";
	public static final String T1C2 = "nombre";
	
	public static final String T2C1 = "ID_COMANDO";
	public static final String T2C2 = "codcomando";
	public static final String T2C3 = "numero";
	public static final String T2C4 = "velocidad";
	public static final String T2C5 = "direccion";
	public static final String T2C6 = "pasos";
	public static final String T2C7 = "ID_ACTO";
	
//Script de Creación de la tabla Acto y comandos
    
    public static final String QUERY_ACTO= "CREATE TABLE "+TABLE_1_NAME+ "("+T1C1+"INTEGER PRIMARY KEY AUTOINCREMENT,"+T1C2+"TEXT UNIQUE);";
    public static final String QUERY_COMANDO= "CREATE TABLE" +TABLE_2_NAME + "("+T2C1+" INTEGER PRIMARY KEY AUTOINCREMENT , "+T2C2+" TEXT,"+T2C3+" TEXT,"+T2C4+" TEXT,"+T2C5+" TEXT,"+T2C6+" TEXT, FOREGIN KEY ("+T2C7+") REFERENCES "+TABLE_1_NAME+"("+T1C1+"));";
    
	
	
	public Handler_db(Context ctx)
	{
		super(ctx,DB_NAME,null,1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		///Por ahora creacion de tablas
		
		db.execSQL(QUERY_ACTO);
		db.execSQL(QUERY_ACTO);
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS"+TABLE_1_NAME);
		db.execSQL("DROP TABLE IF EXISTS"+TABLE_2_NAME);
		onCreate(db);
		
	}
	
	
	public void creaActo(String nom)
	{
		ContentValues valores = new ContentValues();
		
		valores.put("nombre", nom);

		this.getWritableDatabase().insert("acto", null, valores);
	}

		
	public boolean cargaComando(int c, String n, String v, String d, String p,int act)
	{
		//String insert="INSERT INTO comando (codcomando,num,velocidad,direccion,id_acto) VALUES("+c+","+n+","+v+","+d+","+p+","+act+");";
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues valores = new ContentValues();
		
		valores.put(T2C2,c);
		valores.put(T2C3,n);
		valores.put(T2C4,v);
		valores.put(T2C5,d);
		valores.put(T2C6, p);
		valores.put(T2C7,act);
		
		
		Long result = this.getWritableDatabase().insert("comando", null,valores);
		
		if(result == -1)
		{
			return false;
		}
		return true;
		
	}
	
	
	public int getActoid(String nombreacto)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor resu = db.rawQuery("SELECT * FROM"+TABLE_1_NAME+"WHERE nombre="+nombreacto, null);
		
		if(resu.getCount() == 1)
		{
			return resu.getInt(0);
		}
		else return 0;
		
		
	}
	
	
	public void abrir()
	{
		this.getWritableDatabase();
	}
	
	public void cerrar()
	{
		this.close();
	}
	
	

}
