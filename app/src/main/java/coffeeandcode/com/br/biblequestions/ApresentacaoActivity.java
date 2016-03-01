package coffeeandcode.com.br.biblequestions;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import coffeeandcode.com.br.biblequestions.core.database.Database;

public class ApresentacaoActivity extends Activity {

    private Thread mSplashThread;
    private boolean mblnClicou = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresentacao);

        createDatabase();

        //thread para mostrar uma tela de Splash
        mSplashThread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized(this){
                        //Espera por 1 e meio segundos ou sai quando
                        //o usuário tocar na tela
                        wait(1500);
                        mblnClicou = true;
                    }
                }
                catch(InterruptedException ex){
                }

                if (mblnClicou){
                    //fechar a tela de Splash
                    finish();

                    //Carrega a Activity Principal
                    Intent i = new Intent();
                    i.setClass(ApresentacaoActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        };

        mSplashThread.start();
    }

    @Override
    public void onPause()
    {
        super.onPause();

        //garante que quando o usuário clicar no botão
        //"Voltar" o sistema deve finalizar a thread
        mSplashThread.interrupt();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //o método abaixo está relacionado a thread de splash
            synchronized(mSplashThread){
                mblnClicou = true;

                //o método abaixo finaliza o comando wait
                //mesmo que ele não tenha terminado sua espera
                mSplashThread.notifyAll();
            }
        }
        return true;
    }

    //Cria ou Atualiza o banco quando o App é iniciado.
    private void createDatabase() {
        new Database(this);
    }
}
