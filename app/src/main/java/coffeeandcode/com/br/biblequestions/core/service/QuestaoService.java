package coffeeandcode.com.br.biblequestions.core.service;

import android.content.Context;
import android.database.Cursor;

import coffeeandcode.com.br.biblequestions.core.database.DaoUtils;
import coffeeandcode.com.br.biblequestions.core.database.Database;
import coffeeandcode.com.br.biblequestions.core.database.ProjectDao;
import coffeeandcode.com.br.biblequestions.core.model.Questao;

/**
 * Created by Leandro on 28/02/2016.
 */
public class QuestaoService {

    private ProjectDao dao;

    public QuestaoService(Context context){
        dao = new ProjectDao(new Database(context));
    }

    public Questao findById(Integer id){
        //Cursor cs = dao.consultarPorId(DaoUtils.obterNomeTabela(Questao.class), id);
        Integer total = dao.consultarTotalRegistros(DaoUtils.obterNomeTabela(Questao.class));
        Cursor cs = dao.consultarTodos(DaoUtils.obterNomeTabela(Questao.class));
        Questao questao = new Questao();
        questao.convertTo(cs);

        return questao;
    }

    public Questao findQuestaoComMenosExibicoes(){
        return new Questao();
    }
}
