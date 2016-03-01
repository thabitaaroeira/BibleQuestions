package coffeeandcode.com.br.biblequestions.core.model;

/**
 * Created by Leandro on 27/02/2016.
 */
public enum TipoResposta {
    SIMPLES(1, "Simples"),
    MULTIPLA(2, "Multipla");

    private Integer codigo;
    private String descricao;

    private TipoResposta(Integer codigo, String descricao) {
        this.setCodigo(codigo);
        this.descricao = descricao;
    }

    public static TipoResposta getInstance(Integer codigo) {
        for (TipoResposta tipo : TipoResposta.values()) {
            if (tipo.codigo.equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return getDescricao();
    }
}
