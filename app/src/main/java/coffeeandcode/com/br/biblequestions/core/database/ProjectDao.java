/**
 *
 */
package coffeeandcode.com.br.biblequestions.core.database;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;

import coffeeandcode.com.br.biblequestions.core.model.Entidade;

/**
 * @author Leandro
 */
public class ProjectDao {

    private Database banco;
    private Cursor cursor;

    public ProjectDao(Database db) {
        banco = db;
    }

    //testado
    public Long incluir(Entidade entidade) throws Exception {
        return banco.getWritableDatabase().insert(DaoUtils.obterNomeTabela(entidade), null, DaoUtils.getValues(entidade));
    }

    //testado
    public Long alterar(Entidade entidade) throws Exception {
        return banco.getWritableDatabase().replace(DaoUtils.obterNomeTabela(entidade), null, DaoUtils.getValues(entidade));
    }

    //testado
    public int excluir(Entidade entidade) throws Exception {
        StringBuilder where = new StringBuilder();
        where.append(" id = ");
        where.append(entidade.getId());
        return banco.getWritableDatabase().delete(DaoUtils.obterNomeTabela(entidade), where.toString(), null);
    }

    //testado
    public Cursor consultarTodos(String tabela) {
        Cursor cursor = null;
        try {
            cursor = banco.getReadableDatabase().query(tabela, null, null, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cursor;
    }

    //testado
    public Cursor consultarPorId(String tabela, Integer id) {
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(id);
        try {
            return banco.getReadableDatabase().query(tabela, null, sb.toString(), null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer consultarTotalRegistros(String tabela) {
        try {
            cursor = banco.getReadableDatabase().query(tabela, null, null, null, null, null, null);
            return cursor.getCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer consultarWhere(String tabela, String coluna, Object parametro) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(coluna);
            sb.append(" = ");
            sb.append(parametro);
            cursor = banco.getReadableDatabase().query(tabela, null, sb.toString(), null, null, null, null);
            return cursor.getCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Entidade> convertTo(Cursor cs, Entidade entidade) {
        List<Entidade> resultado = new ArrayList<Entidade>();
        while (cs.moveToNext()) {
            //resultado.add(entidade.convertTo(cs));
        }

        return resultado;
    }

    public Entidade convertToSingle(Cursor cs, Entidade entidade) {
        cs.moveToFirst();
        entidade.convertTo(cs);
        return entidade;
    }
}
