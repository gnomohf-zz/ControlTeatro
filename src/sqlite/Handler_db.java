package sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;

import android.content.ContentValues;
import android.content.Context;

public class Handler_db extends SQLiteOpenHelper{
	
	public Handler_db(Context ctx)
	{
		super(ctx,"Teatro",null,1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		///Por ahora creacion de tablas
		
		String query_acto= "CREATE TABLE acto ("+_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+"nombre text);";
		
		String query_comando= "CREATE TABLE comando (ID_COMANDO INTEGER PRIMARY KEY AUTOINCREMENT , codcomando TEXT,num TEXT,velocidad TEXT,direccion TEXT,pasos TEXT, FOREGIN KEY (ID_ACTO) REFERENCES ACTO(_ID));";
		
		db.execSQL(query_acto);
		db.execSQL(query_comando);
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	

	public void cargaComando(int c, String n, String v, String d, String p,String act)
	{
		//String insert="INSERT INTO comando (codcomando,num,velocidad,direccion,id_acto) VALUES("+c+","+n+","+v+","+d+","+p+","+act+");";
		
		ContentValues valores = new ContentValues();
		
		valores.put("codcomando",c);
		valores.put("num",n);
		valores.put("velocidad",v);
		valores.put("direccion",d);
		valores.put("id_acto",act);
		
		this.getWritableDatabase().insert("comando", null,valores);
		
	}
	
	
	
	

}
