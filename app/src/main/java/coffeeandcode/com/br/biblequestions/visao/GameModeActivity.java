package coffeeandcode.com.br.biblequestions.visao;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import coffeeandcode.com.br.biblequestions.MainActivity;
import coffeeandcode.com.br.biblequestions.R;

public class GameModeActivity extends AppCompatActivity {

    private Button btnUmJogador;

    private Button btnVariosJogadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnUmJogador = (Button) findViewById(R.id.buttonOnePlayer);
        btnUmJogador.setOnClickListener(listenerBtnOnePlayer);

        btnVariosJogadores = (Button) findViewById(R.id.buttonMultPlayer);
        btnVariosJogadores.setOnClickListener(listenerBtnMultPlayer);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private View.OnClickListener listenerBtnOnePlayer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                Intent i = new Intent();
                i.setClass(GameModeActivity.this, MainActivity.class);
                startActivity(i);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getCurrentContext(), "Desculpe, houve um erro na operação!",
                        Toast.LENGTH_LONG).show();
            }
        }
    };

    private View.OnClickListener listenerBtnMultPlayer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                Intent i = new Intent();
                i.setClass(GameModeActivity.this, MainActivity.class);
                startActivity(i);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getCurrentContext(), "Desculpe, houve um erro na operação!",
                        Toast.LENGTH_LONG).show();
            }
        }
    };

    private Context getCurrentContext(){
        return this;
    }
}
