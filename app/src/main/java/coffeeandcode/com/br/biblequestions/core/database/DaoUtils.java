/**
 *
 */
package coffeeandcode.com.br.biblequestions.core.database;

import java.lang.reflect.Field;
import java.util.Date;

import android.content.ContentValues;

import coffeeandcode.com.br.biblequestions.core.annotations.Column;
import coffeeandcode.com.br.biblequestions.core.annotations.Table;
import coffeeandcode.com.br.biblequestions.core.model.Entidade;


/**
 * @author Leandro
 */
public class DaoUtils {

    public static String obterNomeTabela(Entidade entidade) {
        String nome;
        if (entidade.getClass().isAnnotationPresent(Table.class)) {
            Table table = entidade.getClass().getAnnotation(Table.class);
            nome = table.nome();

            return nome;
        }

        return null;
    }

    public static String obterNomeTabela(Class<?> entidade) {
        String nome;
        if (entidade.isAnnotationPresent(Table.class)) {
            Table table = entidade.getAnnotation(Table.class);
            nome = table.nome();

            return nome;
        }

        return null;
    }

    public static ContentValues getValues(Entidade entidade) throws Exception {
        ContentValues values = new ContentValues();

        for (Field field : entidade.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                field.setAccessible(true);
                Column coluna = field.getAnnotation(Column.class);
                // Entidade e = (Entidade) obj;
                //values.put(coluna.nome(), getValue(field.get(entidade)));
                getValue(values, coluna.nome(), field.get(entidade));
            }
        }

        return values;
    }

    private static void getValue(ContentValues values, String coluna, Object obj) throws Exception {
        if (obj instanceof String) {
            values.put(coluna, (String) obj);
        } else if (obj instanceof Integer) {
            values.put(coluna, (Integer) obj);
        } else if (obj instanceof Float) {
            values.put(coluna, (Float) obj);
        } else if (obj instanceof Long) {
            values.put(coluna, (Long) obj);
        } else if (obj instanceof Double) {
            values.put(coluna, (Double) obj);
        } else if (obj instanceof Boolean) {
            values.put(coluna, (Boolean) obj);
        } else if (obj instanceof Date) {
            throw new Exception("Não é possível gravar objetos Date");
            //	values.put(coluna, (Date)obj);
        } else if (obj instanceof Entidade) {
            values.put(coluna, ((Entidade) obj).getId());
        }
    }

}
