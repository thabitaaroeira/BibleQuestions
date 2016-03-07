package coffeeandcode.com.br.biblequestions.core.model;

import android.database.Cursor;

import coffeeandcode.com.br.biblequestions.core.annotations.Column;
import coffeeandcode.com.br.biblequestions.core.annotations.Table;

/**
 * Created by Leandro on 27/02/2016.
 */

@Table(nome = "TB_QUESTAO")
public class Questao implements Entidade {

    @Column(nome = "id")
    private Integer id;

    @Column(nome = "descricao")
    private String descricao;

    @Column(nome = "tipo")
    private TipoResposta tipo;

    @Column(nome = "exibicao")
    private Integer exibicao;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void convertTo(Cursor cursor) {
        while (cursor.moveToNext()) {
            id = cursor.getInt(0);
            setDescricao(cursor.getString(1));
            //tipo =
            setExibicao(cursor.getInt(3));
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoResposta getTipo() {
        return tipo;
    }

    public void setTipo(TipoResposta tipo) {
        this.tipo = tipo;
    }

    public Integer getExibicao() {
        return exibicao;
    }

    public void setExibicao(Integer exibicao) {
        this.exibicao = exibicao;
    }
}
