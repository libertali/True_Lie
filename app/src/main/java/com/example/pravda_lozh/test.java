package com.example.pravda_lozh;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;
import android.util.Log;
import android.os.Handler;
import android.os.Message;


public class test extends AppCompatActivity {
    TextView vopros;
    ImageView zagol_test;
    ImageButton true1;
    ImageButton lie;
    ImageButton dalee;
    int serial;
    int NULL = 1;
    int pravda, lozh;
    int stranica = 1;
    String vopr_text;
    boolean istina; // цвет кнопки правда и кнопки ложь (красный или зеленый)
    int rez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();
        String a = intent.getStringExtra("a");
        serial = Integer.parseInt(a);


        vopros = (TextView) findViewById(R.id.vopros);
        zagol_test = (ImageView) findViewById(R.id.zagol_test);
        true1 = (ImageButton) findViewById(R.id.true1);
        lie = (ImageButton) findViewById(R.id.lie);
        dalee = (ImageButton) findViewById(R.id.dalee);

        if (serial == 1) {
            vopros.setText("   Эми училась в Стенфорде.");
            zagol_test.setImageResource(R.drawable.bbt1);
        }
        if (serial == 2) {
            vopros.setText("   Уборщик невзлюбил Джей Ди, так как решил, что он засунул в дверь пени, из-за чего ее заело.");
            zagol_test.setImageResource(R.drawable.scrubs1);
        }
        if (serial == 3) {
            vopros.setText("   Тед украл для Робин синюю тубу.");
            zagol_test.setImageResource(R.drawable.himym1);
        }
        if (serial == 4) {
            vopros.setText("   Правда ли, что Джо пытался доказать свою мужественность Фиби, надев женское нижнее белье?");
            zagol_test.setImageResource(R.drawable.friends1);
        }

    }

    private void setValues() {//таймер
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
        public void run() {mHandler.sendEmptyMessage(NULL);
                    }
            }, 500);}
    public Handler mHandler = new Handler() {//хандлер для таймера
        @Override
        public void handleMessage(android.os.Message msg) {
            NULL = 0;
           if (pravda==1) {vopros.setText( vopr_text);
            if (istina) { true1.setBackgroundResource(R.drawable.true_green);}
                else if (!istina) { true1.setBackgroundResource(R.drawable.true_red);}
            }


           else  { if (lozh==1) {vopros.setText( vopr_text);
               if (istina) { lie.setBackgroundResource(R.drawable.lie_green);}
               else if (!istina) { lie.setBackgroundResource(R.drawable.lie_red);}
           }
              }}
            };

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void sendTrue(View view)  { //нажатие на кнопку правда
        if (NULL==1){
        Intent intent = getIntent(); //получение переменной сномером сериала
        String a = intent.getStringExtra("a");
        int serial = Integer.parseInt(a);
        pravda = 1;
        lozh = 0;
        true1.setBackgroundResource(R.drawable.true_blue);
        lie.setBackgroundResource(R.drawable.lie);
        if (serial==1) { //теория большого взрыва, ответы на вопросы
            switch (stranica) {
                case (1): vopr_text = "     На самом деле она училась в Гарварде. ";
                istina = false;
                    break;
                case (2): vopr_text = "     Шелдон очень расстроился, потому что никак не мог ей возразить.";
                    istina = true;
                    rez++;
                    break;
                case (3): vopr_text = "     Такое название было не про детство Леонарда. А книга называлась «Ребенок разочарования».";
                    istina = false;
                     break;
                case (4): vopr_text = "     Хоть и их планы были нарушены, но Говард все равно устроил Бернадетт приятный сюрприз.";
                    istina = true;
                    rez++;
                     break;
                case (5): vopr_text ="     Элемент он все таки не открыл.";
                    istina = false;
                   break;
                case (6): vopr_text = "     Шелдон всего лишь заставил Леонарда надеть колючий свитер.";
                    istina = false;
                    break;
                case (7): vopr_text = "     Девушка была очень скромная и испугалась его напора.";
                    istina = true;
                    rez++;
                    break;
                case (8): vopr_text = "     На удивление, они поладили и даже вместе напились.";
                    istina = false;
                    break;
                case (9): vopr_text = "     Да, вот такие они фантазеры." ;
                    istina = true;
                    rez++;
                    break;
                case (10): vopr_text = "     Письмо было адресовано Говарду.";
                    istina = false;
                    break;
                case (11): vopr_text = "     У нее пятеро младших братьев и сестер.";
                    istina = false;
                    break;
                case (12): vopr_text = "     Эми — арфистка.";
                    istina = false;
                    break;
                case (13): vopr_text = "     Сцену с ней вырезали из сериала.";
                    istina = false;
                    break;
                case (14): vopr_text = "     Берд стал давить на жалость, и Эми пришлось согласиться, несмотря на то, что у нее есть парень.";
                    istina = true;
                    rez++;
                    break;
                case (15): vopr_text = "     Шелдон постоянно жаловался и в конце концов упал в обморок.";
                    istina = false;
                    break;
                case (16): vopr_text = "     Ребята решили помочь Эми избавиться от настырного ухажера.";
                    istina = true;
                    rez++;
                    break;
                case (17): vopr_text = "     Они хотели нарядиться в костюмы Халка, из разных фильмов.";
                    istina = false;
                    break;
                case (18): vopr_text = "     Этот день Святого Валентина стал для Эми особенным.";
                    istina = true;
                    rez++;
                    break;
                case (19): vopr_text = "     И такое было в сериале.";
                    istina = true;
                    rez++;
                    break;
                case (20): vopr_text = "     Она даже на горящую лампочку «Проверьте двигатель» внимание не обращала.";
                    istina = false;
                    break;
            }
        } else {
            if (serial==2) {//клиника
                switch (stranica) {
                    case (1): vopr_text = "     За это Джей Ди досталось немало. ";
                        istina = true;
                        rez++;
                        break;
                    case (2): vopr_text = "     Чучело пса звали Рауди.";
                        istina = false;
                        break;
                    case (3): vopr_text = "     Вышло забавно.";
                        istina = true;
                        rez++;
                        break;
                    case (4): vopr_text = "     Неправда.";
                        istina = false;
                        break;
                    case (5): vopr_text = "     Хоть Джей Ди и говорил, что выигрыш его не интересует, но как ему подвернулась возможность, тут же ею воспользовался.";
                        istina = false;
                        break;
                    case (6): vopr_text = "     Это, ни так. ";
                        istina = false;
                        break;
                    case (7): vopr_text = "     Джей Ди думал, что уборщик актер.";
                        istina = false;
                        break;
                    case (8): vopr_text = "     Они даже пели на свадьбе Карлы и Терка.";
                        istina = true;
                        rez++;
                        break;
                    case (9): vopr_text = "     Они настолько прониклись ее горем, что решились на такой отчаянный шаг. ";
                        istina = true;
                        rez++;
                        break;
                    case (10): vopr_text = "     У Джей Ди есть только брат — Сэм.";
                        istina = false;
                        break;
                    case (11): vopr_text ="     А Терк его оперировал." ;
                        istina = true;
                        rez++;
                        break;
                    case (12): vopr_text = "     В этом и была интрига.";
                        istina = false;
                        break;
                    case (13): vopr_text = "     Это неправда.";
                        istina = false;
                        break;
                    case (14): vopr_text = "     А вот дрессировщик дельфинов был ее возлюбленным.";
                        istina = false;
                        break;
                    case (15): vopr_text = "     Он сам об этом заявил.";
                        istina = true;
                        rez++;
                        break;
                    case (16): vopr_text = "     Разошлись они правда из-за измены Джордан, но не с Джей Ди.";
                        istina = false;
                        break;
                    case (17): vopr_text = "     Терк подумал, что Марко лакей.";
                        istina = false;
                        break;
                    case (18): vopr_text = "     Да, это так.";
                        istina = true;
                        rez++;
                        break;
                    case (19): vopr_text = "     Она была из Доминиканской республики.";
                        istina = false;
                        break;
                    case (20): vopr_text = "     Пятидневная практика в этой области добавила Эллиот уверенности.";
                        istina = true;
                        rez++;
                        break;
                    case (21): vopr_text = "     На самом деле, ее отец настаивал на этом. И даже лишил ее финансовой поддержки за неподчинение.";
                        istina = false;
                        break;
                    case (22): vopr_text = "     Он даже лечил людей за продукты";
                        istina = true;
                        rez++;
                        break;
                    case (23): vopr_text = "     Оно всем полюбилось. Сидя на этом унитазе, многим приходило озарение.";
                        istina = true;
                        rez++;
                        break;
                }
            }
            else {
                if (serial==3) {//как я встретил вашу маму
                    switch (stranica) {
                        case (1): vopr_text = "     Это была валторна.";
                            istina = false;
                            break;
                        case (2): vopr_text = "     Это один из тех фактов из ее прошлого, которых она стыдится.";
                            istina = true;
                            rez++;
                            break;
                        case (3): vopr_text = "     Однажды ему даже удалось попасть на это шоу.";
                            istina = true;
                            rez++;
                            break;
                        case (4): vopr_text = "     Тед, Лили и Маршал учились в одном колледже, а с Барни они познакомились намного позже.";
                            istina = false;
                            break;
                        case (5): vopr_text = "     Собак Робин дарили ее бывшие парни.";
                            istina = false;
                            break;
                        case (6): vopr_text = "     Она отправилась в Японию.";
                            istina = false;
                            break;
                        case (7): vopr_text = "     По словам Маршала, она печет очень вкусные торты.";
                            istina = true;
                            rez++;
                            break;
                        case (8): vopr_text = "     Нет, она никогда так не думала.";
                            istina = false;
                            break;
                        case (9): vopr_text = "     Отца Маршала звали Марвин.";
                            istina = true;
                            rez++;
                            break;
                        case (10): vopr_text = "     На самом деле галстук был с утками.";
                            istina = false;
                            break;
                        case (11): vopr_text = "     Ее очень обижало, что никто не смотрит эту передачу.";
                            istina = true;
                            rez++;
                            break;
                        case (12): vopr_text = "     Еще и Теду пришлось поработать на этот банк.";
                            istina = false;
                            break;
                        case (13): vopr_text = "     Это была очень длинная история.";
                            istina = true;
                            rez++;
                            break;
                        case (14): vopr_text = "     Забавная ирония, ведь Барни ненавидит Канаду.";
                            istina = true;
                            rez++;
                            break;
                        case (15): vopr_text = "     У Робин есть коллега Патрис, которая очень хотела с ней подружиться и ни раз выручала ее в сложных ситуациях.";
                            istina = false;
                            break;
                        case (16): vopr_text = "     Да, это так.";
                            istina = true;
                            rez++;
                            break;
                        case (17): vopr_text = "     Микки — фанат настолок.";
                            istina = false;
                            break;
                        case (18): vopr_text = "     Тут стоит взять пример.";
                            istina = true;
                            rez++;
                            break;
                        case (19): vopr_text = "     Все таки немного получилось.";
                            istina = false;
                            break;
                        case (20): vopr_text = "     Робин грешит этим даже в прямом эфире.";
                            istina = true;
                            rez++;
                            break;
                        case (21): vopr_text = "     Татуировка была другая.";
                            istina = false;
                            break;
                        case (22): vopr_text = "     Она сожгла не только их.";
                            istina = true;
                            rez++;
                            break;
                    }
                }
                else {
                    if (serial==4) {//друзья
                        switch (stranica) {
                            case (1): vopr_text = "     Когда Джо увидел на бойфренде Фиби женские трусы, он возмущенно поделился этим с Фиби. На что она ему ответила, что только достаточно мужественные мужчины способны одевать женское белье. Вызов был принят.";
                                istina = true;
                                rez++;
                                break;
                            case (2): vopr_text = "     Там поженились Рейчел и Росс. Увидев их, Чендлер и Моника передумали скреплять отношения таким же образом.";
                                istina = false;
                                break;
                            case (3): vopr_text = "     На самом деле это сделал Джо.";
                                istina = false;
                                break;
                            case (4): vopr_text = "     Росс предложил ей поехать вместе, но в последний момент, перед заходом в самолет, увидел Эмили.";
                                istina = true;
                                rez++;
                                break;
                            case (5): vopr_text = "     Хоть награда не была вручена ему, но он сумел ее себе заполучить.";
                                istina = true;
                                rez++;
                                break;
                            case (6): vopr_text = "     Нет, последним узнал новость отец будущего ребенка, Росс.";
                                istina = false;
                                break;
                            case (7): vopr_text = "     Все было как раз наоборот. Чендлер не знал, что подарить Монике, и в последний момент отыскал сборник, который записала ему бывшая подружка Дженис. Все бы было хорошо, если бы на сборнике не был записан голос Дженис с признаниями в любви.";
                                istina = false;
                                break;
                            case (8): vopr_text = "     Да, все так и произошло.";
                                istina = true;
                                rez++;
                                break;
                            case (9): vopr_text = "     Этот отзыв напротив был негативный. Она в пух и прах разнесла это заведение.";
                                istina = false;
                                break;
                            case (10): vopr_text = "     Моника поведала случайной знакомой, где можно купить платье подешевле и рассказала некоторые организационные моменты своей свадьбы. А потом эта девушка пыталась купить платье Моники, что ей не удалось. Дамочка в отместку забронировала группу, которую хотел пригласить Чендлер. Пришлось отдать платье ей.";
                                istina = true;
                                rez++;
                                break;
                            case (11): vopr_text = "     На самом деле, это был сын Стинга, который еще  и задирал Бена.";
                                istina = false;
                                break;
                            case (12): vopr_text = "     Джо осознал, что ему нравится Рейчел на свидании понарошку, куда он пригласил ее, чтобы развеселить.";
                                istina = false;
                                break;
                            case (13): vopr_text = "     Это кладовка, где Моника хранит свой старый хлам. Чендлер из любопытства заставил Монику открыть дверь.";
                                istina = false;
                                break;
                            case (14): vopr_text = "     Фиби нагадала его себе по чаинкам.";
                                istina = true;
                                rez++;
                                break;
                            case (15): vopr_text = "     Заглянув во время декретного отпуска на работу, Рейчел обнаружила приятного мужчину, замещающего ее. Глядя на это, она решила, что ее могут заменить окончательно и приняла спонтанное решение срочно выйти на работу.";
                                istina = true;
                                rez++;
                                break;
                            case (16): vopr_text = "     На самом деле это крысы. Фиби считает их своими домашними животными, но ее приятель Майк относится к ним ни так хорошо.";
                                istina = false;
                                break;
                            case (17): vopr_text = "     Он выбрал рекламу.";
                                istina = false;
                                break;
                            case (18): vopr_text = "     Дело было на Барбадосе.";
                                istina = false;
                                break;
                            case (19): vopr_text = "     В серии «Эпизод со взглядом в прошлое» на месте кофейни показан бар-бильярдная.";
                                istina = true;
                                rez++;
                                break;
                            case (20): vopr_text = "     Для Росса это было мучительное испытание.";
                                istina = true;
                                rez++;
                                break;
                            case (21): vopr_text = "     Дэвид хотел сделать Фиби предложение, но ему не дали шанса.";
                                istina = false;
                                break;
                            case (22): vopr_text = "     Обезьянку звали Марсель.";
                                istina = false;
                                break;
                            case (23): vopr_text = "     Россу пришлось приложить много усилий, чтобы Рейчел осталась в Нью-Йорке.";
                                istina = true;
                                rez++;
                                break;

                        }
                    }

        }

        }}setValues();}}
      public void sendLie(View view) { //нажатие на кнопку ложь
          Intent intent = getIntent(); //получение переменной сномером сериала
          String a = intent.getStringExtra("a");
          int serial = Integer.parseInt(a);
        if (NULL == 1) {
            pravda = 0;
            lozh = 1;
            true1.setBackgroundResource(R.drawable.true1);
            lie.setBackgroundResource(R.drawable.lie_blue);
            if (serial==1) { //теория большого взрыва, ответы на вопросы
                switch (stranica) {
                    case (1): vopr_text = "     На самом деле она училась в Гарварде. ";
                        istina = true;
                      break;
                    case (2): vopr_text = "     Шелдон очень расстроился, потому что никак не мог ей возразить.";
                        istina = false;
                       break;
                    case (3): vopr_text = "     Такое название было не про детство Леонарда. А книга называлась «Ребенок разочарования».";
                        istina = true;
                       break;
                    case (4): vopr_text = "     Хоть и их планы были нарушены, но Говард все равно устроил Бернадетт приятный сюрприз.";
                        istina = false;
                        break;
                    case (5): vopr_text ="     Элемент он все таки не открыл.";
                        istina = true;
                        break;
                    case (6): vopr_text = "     Шелдон всего лишь заставил Леонарда надеть колючий свитер.";
                        istina = true;
                         break;
                    case (7): vopr_text = "     Девушка была очень скромная и испугалась его напора.";
                        istina = false;
                        break;
                    case (8): vopr_text = "     На удивление, они поладили и даже вместе напились.";
                        istina = true;
                        rez++;
                        break;
                    case (9): vopr_text = "     Да, вот такие они фантазеры." ;
                        istina = false;
                        break;
                    case (10): vopr_text = "     Письмо было адресовано Говарду.";
                        istina = true;
                        rez++;
                        break;
                    case (11): vopr_text = "     У нее пятеро младших братьев и сестер.";
                        istina = true;
                        rez++;
                        break;
                    case (12): vopr_text = "     Эми — арфистка.";
                        istina = true;
                        rez++;
                        break;
                    case (13): vopr_text = "     Сцену с ней вырезали из сериала.";
                        istina = true;
                        rez++;
                        break;
                    case (14): vopr_text = "     Берд стал давить на жалость, и Эми пришлось согласиться, несмотря на то, что у нее есть парень.";
                        istina = false;
                        break;
                    case (15): vopr_text = "     Шелдон постоянно жаловался и в конце концов упал в обморок.";
                        istina = true;
                        rez++;
                        break;
                    case (16): vopr_text = "     Ребята решили помочь Эми избавиться от настырного ухажера.";
                        istina = false;
                        break;
                    case (17): vopr_text = "     Они хотели нарядиться в костюмы Халка, из разных фильмов.";
                        istina = true;
                        rez++;
                        break;
                    case (18): vopr_text = "     Этот день Святого Валентина стал для Эми особенным.";
                        istina = false;
                        break;
                    case (19): vopr_text = "     И такое было в сериале.";
                        istina = false;
                        break;
                    case (20): vopr_text = "     Она даже на горящую лампочку «Проверьте двигатель» внимание не обращала.";
                        istina = true;
                        rez++;
                        break;
                }
            }
            else { if (serial==2) {//клиника
                    switch (stranica) {
                        case (1): vopr_text = "     За это Джей Ди досталось немало. ";
                            istina = false;
                            break;
                        case (2): vopr_text = "     Чучело пса звали Рауди.";
                            istina = true;
                            rez++;
                            break;
                        case (3): vopr_text = "     Вышло забавно.";
                            istina = false;
                            break;
                        case (4): vopr_text = "     Неправда.";
                            istina = true;
                            rez++;
                            break;
                        case (5): vopr_text = "     Хоть Джей Ди и говорил, что выигрыш его не интересует, но как ему подвернулась возможность, тут же ею воспользовался.";
                            istina = true;
                            rez++;
                            break;
                        case (6): vopr_text = "     Это, ни так. ";
                            istina = true;
                            rez++;
                            break;
                        case (7): vopr_text = "     Джей Ди думал, что уборщик актер.";
                            istina = true;
                            rez++;
                            break;
                        case (8): vopr_text = "     Они даже пели на свадьбе Карлы и Терка.";
                            istina = false;
                            break;
                        case (9): vopr_text = "     Они настолько прониклись ее горем, что решились на такой отчаянный шаг. ";
                            istina = false;
                            break;
                        case (10): vopr_text = "     У Джей Ди есть только брат — Сэм.";
                            istina = true;
                            rez++;
                            break;
                        case (11): vopr_text ="     А Терк его оперировал." ;
                            istina = false;
                            break;
                        case (12): vopr_text = "     В этом и была интрига.";
                            istina = true;
                            rez++;
                            break;
                        case (13): vopr_text = "     Это неправда.";
                            istina = true;
                            rez++;
                            break;
                        case (14): vopr_text = "     А вот дрессировщик дельфинов был ее возлюбленным.";
                            istina = true;
                            rez++;
                            break;
                        case (15): vopr_text = "     Он сам об этом заявил.";
                            istina = false;
                            break;
                        case (16): vopr_text = "     Разошлись они правда из-за измены Джордан, но не с Джей Ди.";
                            istina = true;
                            rez++;
                            break;
                        case (17): vopr_text = "     Терк подумал, что Марко лакей.";
                            istina = true;
                            rez++;
                            break;
                        case (18): vopr_text = "     Да, это так.";
                            istina = false;
                            break;
                        case (19): vopr_text = "     Она была из Доминиканской республики.";
                            istina = true;
                            rez++;
                            break;
                        case (20): vopr_text = "     Пятидневная практика в этой области добавила Эллиот уверенности.";
                            istina = false;
                            break;
                        case (21): vopr_text = "     На самом деле, ее отец настаивал на этом. И даже лишил ее финансовой поддержки за неподчинение.";
                            istina = true;
                            rez++;
                            break;
                        case (22): vopr_text = "     Он даже лечил людей за продукты";
                            istina = false;
                            break;
                        case (23): vopr_text = "     Оно всем полюбилось. Сидя на этом унитазе, многим приходило озарение.";
                            istina = false;
                            break;
                    }
                }
                else { if (serial==3) {//как я встретил вашу маму
                        switch (stranica) {
                            case (1): vopr_text = "     Это была валторна.";
                                istina = true;
                                rez++;
                                break;
                            case (2): vopr_text = "     Это один из тех фактов из ее прошлого, которых она стыдится.";
                                istina = false;
                                break;
                            case (3): vopr_text = "     Однажды ему даже удалось попасть на это шоу.";
                                istina = false;
                                break;
                            case (4): vopr_text = "     Тед, Лили и Маршал учились в одном колледже, а с Барни они познакомились намного позже.";
                                istina = true;
                                rez++;
                                break;
                            case (5): vopr_text = "     Собак Робин дарили ее бывшие парни.";
                                istina = true;
                                rez++;
                                break;
                            case (6): vopr_text = "     Она отправилась в Японию.";
                                istina = true;
                                rez++;
                                break;
                            case (7): vopr_text = "     По словам Маршала, она печет очень вкусные торты.";
                                istina = false;
                                break;
                            case (8): vopr_text = "     Нет, она никогда так не думала.";
                                istina = true;
                                rez++;
                                break;
                            case (9): vopr_text = "     Отца Маршала звали Марвин.";
                                istina = false;
                                break;
                            case (10): vopr_text = "     На самом деле галстук был с утками.";
                                istina = true;
                                rez++;
                                break;
                            case (11): vopr_text = "     Ее очень обижало, что никто не смотрит эту передачу.";
                                istina = false;
                                break;
                            case (12): vopr_text = "     Еще и Теду пришлось поработать на этот банк.";
                                istina = true;
                                rez++;
                                break;
                            case (13): vopr_text = "     Это была очень длинная история.";
                                istina = false;
                                break;
                            case (14): vopr_text = "     Забавная ирония, ведь Барни ненавидит Канаду.";
                                istina = false;
                                break;
                            case (15): vopr_text = "     У Робин есть коллега Патрис, которая очень хотела с ней подружиться и ни раз выручала ее в сложных ситуациях.";
                                istina = true;
                                rez++;
                                break;
                            case (16): vopr_text = "     Да, это так.";
                                istina = false;
                                break;
                            case (17): vopr_text = "     Микки — фанат настолок.";
                                istina = true;
                                rez++;
                                break;
                            case (18): vopr_text = "     Тут стоит взять пример.";
                                istina = false;
                                break;
                            case (19): vopr_text = "     Все таки немного получилось.";
                                istina = true;
                                rez++;
                                break;
                            case (20): vopr_text = "     Робин грешит этим даже в прямом эфире.";
                                istina = false;
                                break;
                            case (21): vopr_text = "     Татуировка была другая.";
                                istina = true;
                                rez++;
                                break;
                            case (22): vopr_text = "     Она сожгла не только их.";
                                istina = false;
                                break;
                        }
                    }
             else { if (serial == 4) {//друзья
                switch (stranica) {
                    case (1):
                        vopr_text = "     Когда Джо увидел на бойфренде Фиби женские трусы, он возмущенно поделился этим с Фиби. На что она ему ответила, что только достаточно мужественные мужчины способны одевать женское белье. Вызов был принят.";
                        istina = false;
                        break;
                    case (2):
                        vopr_text = "     Там поженились Рейчел и Росс. Увидев их, Чендлер и Моника передумали скреплять отношения таким же образом.";
                        istina = true;
                        rez++;
                        break;
                    case (3):
                        vopr_text = "     На самом деле это сделал Джо.";
                        istina = true;
                        rez++;
                        break;
                    case (4):
                        vopr_text = "     Росс предложил ей поехать вместе, но в последний момент, перед заходом в самолет, увидел Эмили.";
                        istina = false;
                        break;
                    case (5):
                        vopr_text = "     Хоть награда не была вручена ему, но он сумел ее себе заполучить.";
                        istina = false;
                        break;
                    case (6):
                        vopr_text = "     Нет, последним узнал новость отец будущего ребенка, Росс.";
                        istina = true;
                        rez++;
                        break;
                    case (7):
                        vopr_text = "     Все было как раз наоборот. Чендлер не знал, что подарить Монике, и в последний момент отыскал сборник, который записала ему бывшая подружка Дженис. Все бы было хорошо, если бы на сборнике не был записан голос Дженис с признаниями в любви.";
                        istina = true;
                        rez++;
                        break;
                    case (8):
                        vopr_text = "     Да, все так и произошло.";
                        istina = false;
                        break;
                    case (9):
                        vopr_text = "     Этот отзыв напротив был негативный. Она в пух и прах разнесла это заведение.";
                        istina = true;
                        rez++;
                        break;
                    case (10):
                        vopr_text = "     Моника поведала случайной знакомой, где можно купить платье подешевле и рассказала некоторые организационные моменты своей свадьбы. А потом эта девушка пыталась купить платье Моники, что ей не удалось. Дамочка в отместку забронировала группу, которую хотел пригласить Чендлер. Пришлось отдать платье ей.";
                        istina = false;
                        break;
                    case (11):
                        vopr_text = "     На самом деле, это был сын Стинга, который еще  и задирал Бена.";
                        istina = true;
                        rez++;
                        break;
                    case (12):
                        vopr_text = "     Джо осознал, что ему нравится Рейчел на свидании понарошку, куда он пригласил ее, чтобы развеселить.";
                        istina = true;
                        rez++;
                        break;
                    case (13):
                        vopr_text = "     Это кладовка, где Моника хранит свой старый хлам. Чендлер из любопытства заставил Монику открыть дверь.";
                        istina = true;
                        rez++;
                        break;
                    case (14):
                        vopr_text = "     Фиби нагадала его себе по чаинкам.";
                        istina = false;
                        break;
                    case (15):
                        vopr_text = "     Заглянув во время декретного отпуска на работу, Рейчел обнаружила приятного мужчину, замещающего ее. Глядя на это, она решила, что ее могут заменить окончательно и приняла спонтанное решение срочно выйти на работу.";
                        istina = false;
                        break;
                    case (16):
                        vopr_text = "     На самом деле это крысы. Фиби считает их своими домашними животными, но ее приятель Майк относится к ним ни так хорошо.";
                        istina = true;
                        rez++;
                        break;
                    case (17):
                        vopr_text = "     Он выбрал рекламу.";
                        istina = true;
                        rez++;
                        break;
                    case (18):
                        vopr_text = "     Дело было на Барбадосе.";
                        istina = true;
                        rez++;
                        break;
                    case (19):
                        vopr_text = "     В серии «Эпизод со взглядом в прошлое» на месте кофейни показан бар-бильярдная.";
                        istina = false;
                        break;
                    case (20):
                        vopr_text = "     Для Росса это было мучительное испытание.";
                        istina = false;
                        break;
                    case (21):
                        vopr_text = "     Дэвид хотел сделать Фиби предложение, но ему не дали шанса.";
                        istina = true;
                        rez++;
                        break;
                    case (22):
                        vopr_text = "     Обезьянку звали Марсель.";
                        istina = true;
                        rez++;
                        break;
                    case (23):
                        vopr_text = "     Россу пришлось приложить много усилий, чтобы Рейчел осталась в Нью-Йорке.";
                        istina = false;
                        break;
                }}
             }}//
             }
            setValues();
    }}
    public void sendDalee (View view) { //нажатие на кнопку далее
        Intent intent = getIntent(); //получение переменной сномером сериала
        String a = intent.getStringExtra("a");
        int serial = Integer.parseInt(a);


        if (NULL==0){

            stranica++;
            true1.setBackgroundResource(R.drawable.true1);
            lie.setBackgroundResource(R.drawable.lie);
            NULL = 1;
            if (serial==1) { //теория большого взрыва, вопросы
                switch (stranica) {
                    case (2): vopros.setText("     Эми ошарашила Шелдона тем, что в фильме «В поисках утраченного ковчега», Индиана Джонс никак не влияет на сюжет.");break;
                    case (3): vopros.setText("     Мать Леонарда написала книгу «Счастливый ребенок», в которой описано его детство."); break;
                    case (4): vopros.setText("     Бернадетт попала в карантин на годовщину отношений с Говардом."); break;
                    case (5): vopros.setText("     Шелдон открыл химический элемент из-за ошибки в расчетах."); break;
                    case (6): vopros.setText("     Леонард не сдал во время диск обратно в прокат, и Шелдон заставил его всюду добираться пешком, пока он не сдаст его обратно."); break;
                    case (7): vopros.setText("     От Раджа сбежала девушка через окно туалета."); break;
                    case (8): vopros.setText("     Шелдон на дне благодарения в гостях у Говарда поругался с отцом Бернадетт."); break;
                    case (9): vopros.setText("     Ребята решили пофантазировать, как бы сложилась их жизнь без Шелдона. И в одном из вариантов, в котором Леонард и Радж съехались, они были бы толстыми."); break;
                    case (10): vopros.setText("     Когда Шелдон убирался в кладовке Говарда, нашел там письмо от его отца к его матери."); break;
                    case (11): vopros.setText("     Бернадетт — единственный ребенок в семье."); break;
                    case (12): vopros.setText("     Эми играет на виолончели."); break;
                    case (13): vopros.setText("     Пенни сыграла эпизодическую роль официантки в сериале, и после этого ее карьера актрисы пошла в гору."); break;
                    case (14): vopros.setText("     Берд пригласил на свидание Эми, и ей даже пришлось согласиться."); break;
                    case (15): vopros.setText("     Шелдон помогал принимать домашние роды у своей сестры, и был там очень полезен."); break;
                    case (16): vopros.setText("     Говарду и Раджу пришлось ехать с Бердом на выставку камней и минералов вместо Эми."); break;
                    case (17): vopros.setText("     Ребята подготовили костюмы разных Бэтменов на Комик Кон, на который даже не смогли попасть."); break;
                    case (18): vopros.setText("     Шелдон и Эми впервые поцеловались в поезде."); break;
                    case (19): vopros.setText("     Шелдон чуть не бросил Эми из-за стола, который купил Леонард."); break;
                    case (20): vopros.setText("     Пенни может самостоятельно починить машину."); break;
                    case (21): String rez1 = Integer.toString(rez);
                        String str2 = Integer.toString(stranica);
                        Intent rez2 = new Intent(this, rezult.class);
                        rez2.putExtra("rez1", rez1);
                        rez2.putExtra("str2", str2);
                        rez2.putExtra("a", a);
                        startActivity(rez2); break;
                }
                }
            else { if (serial==2){//клиника
                switch (stranica) {
                    case (2): vopros.setText("     Джей Ди и Терк дали имя Рауль своему чучелу собаки."); break;
                    case (3): vopros.setText("     Эллиот решила, что у нее волшебная грудь, которая может излечить больных."); break;
                    case (4): vopros.setText("     Тед был тайно влюблен в Эллиот."); break;
                    case (5): vopros.setText("     Джей Ди, несмотря на то, что ему попался крайне интересный случай, не участвовал в конкурсе, который устроил Келсо, суть которого заключалась в выборе самого необычного случая из практики. Причина в том, что Джей Ди солидарен с Коксом: перед начальством прогибаться нельзя."); break;
                    case (6): vopros.setText("     Карла и уборщик бывшие супруги."); break;
                    case (7): vopros.setText("     Джей Ди считает, что уборщик в прошлом был музыкантом."); break;
                    case (8): vopros.setText("     Юрист клиники, Тед, организовал певческий квартет."); break;
                    case (9): vopros.setText("     Карла и Эллиот искали мужчину-проститутку для умирающей пациентки."); break;
                    case (10): vopros.setText("     У Джей Ди есть сестра Саманта."); break;
                    case (11): vopros.setText("     Джей Ди сам лежал в больнице с воспаленным аппендицитом."); break;
                    case (12): vopros.setText("     Брат Карлы не знает английский язык."); break;
                    case (13): vopros.setText("     Тед может спать с открытыми глазами."); break;
                    case (14): vopros.setText("     Эллиот встречалась с сотрудником зоопарка."); break;
                    case (15): vopros.setText("     Перри Кокс ненавидит актера Хью Джекмана."); break;
                    case (16): vopros.setText("     Джордан изменила Перри с Джей Ди, из-за этого они разошлись."); break;
                    case (17): vopros.setText("     Когда Терк впервые увидел брата Карлы, он принял его за уборщика."); break;
                    case (18): vopros.setText("     Мать Терка состоит в свидетелях Иеговы."); break;
                    case (19): vopros.setText("     Эллиот воспитывала горничная из Мексики."); break;
                    case (20): vopros.setText("     Эллиот считала себя специалистом в области эндокринологии."); break;
                    case (21): vopros.setText("     Эллиот хотела пойти в гинекологию."); break;
                    case (22): vopros.setText("     Прадед доктора Келсо также был врачом."); break;
                    case (23): vopros.setText("    Уборщик соорудил на крыше уборное место."); break;
                    case (24): String rez1 = Integer.toString(rez);
                        String str2 = Integer.toString(stranica);
                        Intent rez2 = new Intent(this, rezult.class);
                        rez2.putExtra("rez1", rez1);
                        rez2.putExtra("str2", str2);
                        rez2.putExtra("a", a);
                        startActivity(rez2); break;
            }
              }
            else {if (serial==3){//как я встретил вашу маму
                switch (stranica) {
                    case (2): vopros.setText("     Робин пела в канадской поп группе."); break;
                    case (3): vopros.setText("     Барни думал, что его отец - ведущий телевикторины."); break;
                    case (4): vopros.setText("     Лили, Маршал и Барни - друзья с колледжа"); break;
                    case (5): vopros.setText("     Собаки Робин достались ей в наследство."); break;
                    case (6): vopros.setText("     Робин поехала в Южную Корею после увольнения с Метро Ньюс 1."); break;
                    case (7): vopros.setText("     Одна из бывших подруг Теда, Виктория, - кондитер."); break;
                    case (8): vopros.setText("     В одной из серий Робин думала, что беременна от Теда."); break;
                    case (9): vopros.setText("     Своего сына Маршал и Лили назвали в честь отца Маршала."); break;
                    case (10): vopros.setText("     Барни проиграл в споре с Маршалом и Лили, и, в итоге, был вынужден носить желтый галстук с гусями."); break;
                    case (11): vopros.setText("     Робин как-то вела утреннее шоу, которое начиналось в 4 утра."); break;
                    case (12): vopros.setText("     Из их компании только Барни и Маршал в разное время работали на банк «Голиаф»."); break;
                    case (13): vopros.setText("     Робин чуть не вышла замуж за своего психолога."); break;
                    case (14): vopros.setText("     Барни на четверть канадец."); break;
                    case (15): vopros.setText("     Лили — единственная подруга Робин."); break;
                    case (16): vopros.setText("     Барни любит играть в пейнтбол."); break;
                    case (17): vopros.setText("     Отец Лили отчаянно пытается создать популярную компьютерную игру."); break;
                    case (18): vopros.setText("     Маршал всегда мечтал работать юристом по охране природы, и ему удалось осуществить мечту."); break;
                    case (19): vopros.setText("     У Теда и Барни периодически возникала идея - открыть бар, но так они ее и не реализовали."); break;
                    case (20): vopros.setText("     В речи Робин присутствуют слова-паразиты: «Буквально» и «Это самое»."); break;
                    case (21): vopros.setText("     Тед познакомился со Стеллой, когда пришел к ней на прием, чтобы удалить татуировку с птицей."); break;
                    case (22): vopros.setText("     Сумасшедшая подружка Теда сожгла его красные сапоги."); break;
                    case (23): String rez1 = Integer.toString(rez);
                        String str2 = Integer.toString(stranica);
                        Intent rez2 = new Intent(this, rezult.class);
                        rez2.putExtra("rez1", rez1);
                        rez2.putExtra("str2", str2);
                        rez2.putExtra("a", a);
                        startActivity(rez2); break;
            }

            }else{{if (serial==4){//друзья
                switch (stranica) {
                    case (2): vopros.setText("     Чендлер и Моника поженились в Лас-Вегасе."); break;
                    case (3): vopros.setText("     С Майком Фиби познакомил Росс."); break;
                    case (4): vopros.setText("     После неудачной свадьбы Росса и Эмили в их свадебное путешествие поехала Рейчел."); break;
                    case (5): vopros.setText("     Джо досталась награда «Мыльный пузырь»."); break;
                    case (6): vopros.setText("     Последним из друзей о беременности Рейчел узнал Чендлер."); break;
                    case (7): vopros.setText("     Моника подарила Чендлеру сборник романтических песен, который записал ей Ричард."); break;
                    case (8): vopros.setText("     Рейчел настолько была выбита из колеи предстоящей свадьбой Росса и Эмили. Подружки, для поднятия настроения, уговорили ее надеть свадебное платье. За этим занятием их застал Джошуа (бойфрэнд Рэйчел). Это и было последней каплей, ведущей к их разрыву."); break;
                    case (9): vopros.setText("     Получить долгожданную работу шеф-поваром, Монике помог хвалебный отзыв, который она опубликовала в газету в качестве кулинарного критика."); break;
                    case (10): vopros.setText("     Моника лишилась свадебного платья мечты из-за любимой группы Чендлера."); break;
                    case (11): vopros.setText("     Сын Росса, Бен, ходит в одну школу с сыном Брайна Адамса."); break;
                    case (12): vopros.setText("     Джо понял, что ему нравится Рейчел, когда они стали вместе жить."); break;
                    case (13): vopros.setText("     В квартире Моники, есть дверь, которая заперта, и вход за нее под запретом. Это тайный кабинет Моники."); break;
                    case (14): vopros.setText("     Алек Болдуин играет в сериале романтичного бойфренда Фиби."); break;
                    case (15): vopros.setText("     Рейчел раньше времени вышла на работу из декретного отпуска, потому что боялась, что ее подсидит замещающий коллега."); break;
                    case (16): vopros.setText("     У Фиби в квартире живут опоссумы."); break;
                    case (17): vopros.setText("     Чендлер решил кардинально изменить свою карьеру и пошел работать в сферу продаж."); break;
                    case (18): vopros.setText("     Во время поездки на Карибы Рейчел и Джо решили начать встречаться."); break;
                    case (19): vopros.setText("     На месте центральной кофейни раньше был бар."); break;
                    case (20): vopros.setText("     Когда Россу было 14, его ограбила Фиби."); break;
                    case (21): vopros.setText("     Фиби окончательно рассталась с Дэвидом на Барбадосе."); break;
                    case (22): vopros.setText("     У Росса была обезьянка по имени Лион."); break;
                    case (23): vopros.setText("     Чтобы остановить Рейчел от переезда в Париж, Россу пришлось подарить бывшему боссу Рейчел окаменелое яйцо динозавра."); break;
                    case (24): String rez1 = Integer.toString(rez);
                        String str2 = Integer.toString(stranica);
                        Intent rez2 = new Intent(this, rezult.class);
                        rez2.putExtra("rez1", rez1);
                        rez2.putExtra("str2", str2);
                        rez2.putExtra("a", a);
                        startActivity(rez2); break;

                }

            }
        }
        }
    }
}}}}