package com.example.pravda_lozh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class rezult extends AppCompatActivity {
    TextView text_rez;
    TextView rech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezult);
        text_rez = (TextView) findViewById(R.id.text_rez);
        rech = (TextView) findViewById(R.id.rech);
        Intent rez2 = getIntent();
        String rez1 = rez2.getStringExtra("rez1");
        String str2 = rez2.getStringExtra("str2");
        String a = rez2.getStringExtra("a");
        text_rez.setText("Твой результат: " + rez1 + " из " + str2 + "!");
        int serial = Integer.parseInt(a);
        int rez = Integer.parseInt(rez1);

        if (serial==3) {
            if (rez<=10) {rech.setText("   Пришло время скачать «Как я встретил вашу маму» и посвятить сериалу несколько вечеров. Поверь, это того стоит.");}
           else { if (rez<=16) { rech.setText( "   Еще чуть-чуть, и ты будешь специалистом по сериалам. Терпение и приятный просмотр тебе помогут.");}
          else {  rech.setText("   У тебя талант смотреть сериалы! Ничего не проходит мимо тебя. Так держать!");     } }}
       else {
            if (serial == 4) {
                if (rez < 11) {
                    rech.setText("   Пришло время скачать друзей и посвятить им несколько вечеров. Поверь, это того стоит.");
                }
                else {  if (rez > 10 && rez < 16) {
                    rech.setText("   Еще чуть-чуть, и ты будешь специалистом по сериалам. Терпение и приятный просмотр тебе помогут.");
                }
                else { if (rez > 17) {
                    rech.setText("   У тебя талант смотреть сериалы! Ничего не проходит мимо тебя. Так держать!");
                }
            }}}
           else { if (serial == 1 || serial == 2) {
                if (rez < 11) {
                    rech.setText("   Стоит пересмотреть сериал еще раз. Видимо, какие-то детали прошли мимо тебя. Но это ведь хорошо, можно заново пережить все радостные моменты сериала.");
                }
                else { if (rez < 16 && rez > 10) {
                    rech.setText("   Умница! Ты хорошо посмотрел сериал, основное запомнил. А тонкости — это дело второе.");
                }
                else { if (rez>17) {
                    rech.setText("   Про тебя можно сказать, что ты в теме. Поздравляю, крутой чувак, ты — молодец!");
                }
            }}}}

        }}
    @Override
    public void onBackPressed() {
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }

}
