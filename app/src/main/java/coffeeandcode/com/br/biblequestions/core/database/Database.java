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
 */
public class Database extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "BibleQuestionsApp.db";
    public final static Integer DATABASE_VERSION = 1;


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Metodo executado ao instalar o App
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            StringBuilder createTableQuestao = new StringBuilder();
            StringBuilder createTableOpcResposta = new StringBuilder();

            createTableQuestao.append("CREATE TABLE IF NOT EXISTS [TB_QUESTAO] ( ");
            createTableQuestao.append(" [id] integer NOT NULL PRIMARY KEY AUTOINCREMENT, ");
            createTableQuestao.append(" [descricao] VARCHAR2(400) NOT NULL, ");
            createTableQuestao.append(" [tipo] integer NOT NULL, ");
            createTableQuestao.append(" [exibicao] integer NOT NULL  ");
            createTableQuestao.append(" ); ");

            createTableOpcResposta.append("CREATE TABLE IF NOT EXISTS [TB_OPCRESPOSTA] ( ");
            createTableOpcResposta.append(" [id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,  ");
            createTableOpcResposta.append(" [id_questao] INTEGER NOT NULL CONSTRAINT [fk_opcresposta_questao] REFERENCES [TB_QUESTAO](id),  ");
            createTableOpcResposta.append(" [descricao] VARCHAR2(100) NOT NULL, ");
            createTableOpcResposta.append(" [resposta_correta] boolean ");
            createTableOpcResposta.append(" ); ");


            db.execSQL(createTableQuestao.toString());
            db.execSQL(createTableOpcResposta.toString());
            db.execSQL("insert into TB_QUESTAO values (1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 1, 0);");
            db.execSQL("insert into TB_QUESTAO values (2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua 2', 1, 0);");
            db.execSQL("insert into TB_QUESTAO values (3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua 3', 2, 0);");
            db.execSQL("insert into TB_OPCRESPOSTA values (1, 1, 'Verdadeiro', 1);");
            db.execSQL("insert into TB_OPCRESPOSTA values (2, 1, 'Falso', 0);");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo executado caso DATABASE_VERSION atual seja superior ao DATABASE_VERSION instalado
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("onupgrade");
        try {
            StringBuilder scriptUpdate = new StringBuilder();

//			db.execSQL(" insert into table values (1, 'val'); ");
//			db.execSQL(" insert into table values (2, 'val'); ");

            //db.execSQL(createTable.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
