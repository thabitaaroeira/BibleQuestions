package coffeeandcode.com.br.biblequestions;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import coffeeandcode.com.br.biblequestions.core.model.Questao;
import coffeeandcode.com.br.biblequestions.core.service.QuestaoService;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private QuestaoService questaoService;
    private TextView descricaoQuestao;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        questaoService = new QuestaoService(this.getContext());

        descricaoQuestao = (TextView) view.findViewById(R.id.descQuestao);
        descricaoQuestao.setText(montarTexto());

        return view;
    }

    private String montarTexto() {
        Questao questao = questaoService.findById(1);
        return questao.getDescricao();
    }
}
