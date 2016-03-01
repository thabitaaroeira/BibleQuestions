/**
 * 
 */
package coffeeandcode.com.br.biblequestions.core.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Leandro
 *
 */
public class Database extends SQLiteOpenHelper{

	public final static String DATABASE_NAME = "BibleQuestionsApp";
	public final static Integer DATABASE_VERSION = 1;
	

	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

    /**
     * Metodo executado ao instalar o App
     * @param db
     */
	@Override
	public void onCreate(SQLiteDatabase db) {
		try{			
			StringBuilder createTable = new StringBuilder();
			createTable.append("CREATE TABLE IF NOT EXISTS [TB_QUESTAO] ( ");
			createTable.append(" [id] integer NOT NULL PRIMARY KEY AUTOINCREMENT, "); 
			createTable.append(" [descricao] VARCHAR2(400) NOT NULL, ");
			createTable.append(" [tipo] integer NOT NULL, ");
			createTable.append(" [exibicao] integer NOT NULL); ");
			
			createTable.append("CREATE TABLE IF NOT EXISTS [TB_OPCRESPOSTA] ( ");
			createTable.append(" [id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,  "); 
			createTable.append(" [id_questao] INTEGER NOT NULL CONSTRAINT [fk_opcresposta_questao] REFERENCES [TB_QUESTAO]([id]),  ");
			createTable.append(" [descricao] VARCHAR2(100) NOT NULL, ");
			createTable.append(" [resposta_correta] boolean ); ");
			
			createTable.append(" insert into TB_QUESTAO values (1, 'desc', 1, 0) ");
			createTable.append(" insert into TB_QUESTAO values (2, 'desc2'), 1, 0 ");
			createTable.append(" insert into TB_QUESTAO values (3, 'desc3'), 2, 0 ");
			createTable.append(" insert into TB_OPCRESPOSTA values (1, 1, 'desc 1', true) ");
			createTable.append(" insert into TB_OPCRESPOSTA values (1, 1, 'desc 2', false) ");
			
			db.execSQL(createTable.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}

    /**
     * Metodo executado caso DATABASE_VERSION atual seja superior ao DATABASE_VERSION instalado
     * @param db
     * @param oldVersion
     * @param newVersion
     */
	@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("onupgrade");
		try{			
			StringBuilder scriptUpdate = new StringBuilder();
			
			db.execSQL(" insert into table values (1, 'val'); ");
			db.execSQL(" insert into table values (2, 'val'); ");
			
			//db.execSQL(createTable.toString());			
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
