package com.example.cir;




import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Double result;

    Button btnRem;



    View.OnClickListener listner1 = new View.OnClickListener()  {
        @Override
        public void onClick(View v) {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Double.parseDouble(num1) + Double.parseDouble(num2);
            textResult.setText("계산 결과 : " + result.toString());
            // return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnRem = (Button) findViewById(R.id.BtnRem);

        textResult = (TextView) findViewById(R.id.TextResult);

      /*  btnAdd.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Double.parseDouble(num1) + Double.parseDouble(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });*/

        btnAdd.setOnClickListener(listner1);

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Double.parseDouble(num1) - Double.parseDouble(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Double.parseDouble(num1) * Double.parseDouble(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    //Toast t1 = new Toast();

                    Toast.makeText(getApplicationContext(), "값이 비었습니다", Toast.LENGTH_SHORT).show();

                } else {
                    if (num2.equals("0")) {
                        Toast.makeText(getApplicationContext(), "0으로 못나눔!", Toast.LENGTH_SHORT).show();
                    } else {
                        result = Double.parseDouble(num1) / Double.parseDouble(num2);
                        result = ((int) (result * 100)) / 100.0;
                        textResult.setText("계산 결과 : " + result.toString());
                    }
                }
            }
        });

        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    //Toast t1 = new Toast();

                    Toast.makeText(getApplicationContext(), "값이 비었습니다", Toast.LENGTH_SHORT).show();

                } else {
                    if (num2.equals("0")) {
                        Toast.makeText(getApplicationContext(), "0으로 못나눔!", Toast.LENGTH_SHORT).show();
                    } else {
                        result = Double.parseDouble(num1) % Double.parseDouble(num2);
                        textResult.setText("계산 결과 : " + result.toString());
                    }
                }
            }
        });


    }
}