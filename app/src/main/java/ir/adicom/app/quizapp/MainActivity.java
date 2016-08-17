package ir.adicom.app.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String questions[] = {
            "قهرمان جام جهانی 2002 کدام تیم است؟",
            "قهرمان جام جهانی 2006 کدام تیم است؟",
            "قهرمان جام جهانی 2010 کدام تیم است؟",
            "قهرمان جام جهانی 2014 کدام تیم است؟"
    };
    String[][] answers = {
            {"ایتالیا","المان","برزیل","فرانسه"},
            {"المان","برزیل","فرانسه","ایتالیا"},
            {"المان","اسپانیا","فرانسه","هلند"},
            {"المان","برزیل","فرانسه","ارژانتین"}
    };
    int[] correctAnswer = {
            2,
            3,
            1,
            0
    };
    int index = 0;
    int correct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtQuestion = (TextView) findViewById(R.id.textView);
        TextView txtIndex = (TextView) findViewById(R.id.textView2);
        final RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
        final RadioButton rb4 = (RadioButton) findViewById(R.id.radioButton4);
        final Button btnSubmit = (Button) findViewById(R.id.button);
        final RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);

        if (index < questions.length) {
            txtQuestion.setText(questions[index]);
            rb1.setText(answers[index][0]);
            rb2.setText(answers[index][1]);
            rb3.setText(answers[index][2]);
            rb4.setText(answers[index][3]);
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < questions.length) {
                    int id = group.getCheckedRadioButtonId();
                    RadioButton t = (RadioButton) findViewById(id);
                    String strCorrect = answers[index][correctAnswer[index]];
                    if (strCorrect.equals(t.getText())) {
                        correct++;
                    }
                }
                index++;
                if (index < questions.length) {
                    txtQuestion.setText(questions[index]);
                    rb1.setText(answers[index][0]);
                    rb2.setText(answers[index][1]);
                    rb3.setText(answers[index][2]);
                    rb4.setText(answers[index][3]);
                } else {
                    txtQuestion.setEnabled(false);
                    rb1.setEnabled(false);
                    rb2.setEnabled(false);
                    rb3.setEnabled(false);
                    rb4.setEnabled(false);
                    btnSubmit.setEnabled(false);
                    Toast.makeText(getApplicationContext(),"جواب درست : " + correct, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
