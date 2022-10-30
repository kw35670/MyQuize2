package com.example.myquize2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private TextView questionText;
    private RadioButton[] selectionRadioButtons = new RadioButton[4];
    private Button finalAnswerButton;
    private TextView resultText;
    private static final int questionId = R.id.question;
    private static final int[] selectionId = {R.id.rdi_1, R.id.rdi_2, R.id.rdi_3, R.id.rdi_4};
    private static final int finalAnswerId = R.id.finalAnswer;
    private static final int resultId = R.id.result;
    private String question;
    private ArrayList<String> selections;
    private int correctNumber;
    private Quize quize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Quize> questions = new ArrayList<>();
        questions.add(new Quize("中国の首都はどこか",new String[]{"台北", "北京", "上海", "西安"},2));
        questions.add(new Quize("中国の人口の9割以上を占める民族は何民族か",new String[]{"唐民族", "アイヌ民族", "満州民族", "漢民族"},4));
        questions.add(new Quize("中国の華北平原を流れる運河はどれか",new String[]{"ナイル川", "長江", "ガンジス川", "黄河"},4));
        questions.add(new Quize("チベットから中国にかけて広がる世界最大の山脈は何山脈か",new String[]{"アンデス山脈", "アルプス山脈", "ヒマラヤ山脈", "ロッキー山脈"},3));
        questions.add(new Quize("中国が人口抑制のために行っている政策は何か",new String[]{"一人っ子政策", "5か年計画", "改革開放", "人口改革"},1));
        questions.add(new Quize("韓国の首都はどこか",new String[]{"ソウル", "インチョン", "ピョンヤン", "プサン"},1));
        questions.add(new Quize("『東南アジア連合』の略称を何というか",new String[]{"OPEC", "WTO", "APEC", "ASEAN"},4));
        questions.add(new Quize("世界第2位の人口がある国はどこか",new String[]{"台北", "北京", "上海", "西安"},1));
        questions.add(new Quize("『アジア太平洋経済協力』",new String[]{"インド", "インドネシア", "中国", "ロシア"},2));
        questions.add(new Quize("安価な労働力を使って単一作物を大量に栽培する大規模農園のことを何というか",new String[]{"プランバレー", "プランテーション", "モノカルチャー", "単一作園"},2));

        String a = questions.get(0).getQuestion();
        ArrayList<String> b = questions.get(0).getSelections();
        int c = questions.get(0).getCorrectNumber();

        getQuizes(a, b, c);
        getViews();
        setQuize();
        setListener();
    }

    private void getViews() {
        questionText = findViewById(questionId);
        for (int i=0; i<selectionId.length; i++) {
            selectionRadioButtons[i] = findViewById(selectionId[i]);
        }
        selectionRadioButtons[0].setChecked(true);
        finalAnswerButton = findViewById(finalAnswerId);
        resultText = findViewById(resultId);
    }

    private void setListener() {
        finalAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean correct = false;
                for (int i=0; i<selectionRadioButtons.length; i++) {
                    if (selectionRadioButtons[i].isChecked()) {
                        if (i==quize.getCorrectNumber()-1) {
                            correct = true;
                        }
                        break;
                    }
                }
                if (correct) {
                    resultText.setText("正解です");
                } else {
                    resultText.setText("間違いです");
                }
            }
        });
    }

    private void setQuize() {
        questionText.setText(quize.getQuestion());
        for (int i=0; i<selectionId.length; i++) {
            selectionRadioButtons[i].setText(quize.getSelections().get(i));
        }
    }

    private void getQuizes(String question, ArrayList<String> selections, int correctNumber) {
        this.question = "aaa";
        this.selections = new ArrayList<String>(Arrays.asList("唐民族", "アイヌ民族", "満州民族", "漢民族"));
        this.correctNumber = 5;
    }
}
