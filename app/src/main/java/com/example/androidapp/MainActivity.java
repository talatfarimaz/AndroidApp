package com.example.androidapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public EditText getProcessText() {
        return processText;
    }

    public void setProcessText(EditText processText) {
        this.processText = processText;
    }

    private EditText processText;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        processText = findViewById(R.id.process);
        resultText = findViewById(R.id.resultText);
        setOnClickActionToImageButtons();
    }

    public void setOnClickActionToImageButtons() {
        ImageButton one = findViewById(R.id.one);
        one.setOnClickListener(this);
        ImageButton two = findViewById(R.id.two);
        two.setOnClickListener(this);
        ImageButton three = findViewById(R.id.three);
        three.setOnClickListener(this);
        ImageButton four = findViewById(R.id.four);
        four.setOnClickListener(this);
        ImageButton five = findViewById(R.id.five);
        five.setOnClickListener(this);
        ImageButton six = findViewById(R.id.six);
        six.setOnClickListener(this);
        ImageButton seven = findViewById(R.id.seven);
        seven.setOnClickListener(this);
        ImageButton eight = findViewById(R.id.eight);
        eight.setOnClickListener(this);
        ImageButton nine = findViewById(R.id.nine);
        nine.setOnClickListener(this);
        ImageButton zero = findViewById(R.id.zero);
        zero.setOnClickListener(this);
        ImageButton divide = findViewById(R.id.divide);
        divide.setOnClickListener(this);
        ImageButton add = findViewById(R.id.add);
        add.setOnClickListener(this);
        ImageButton minus = findViewById(R.id.minus);
        minus.setOnClickListener(this);
        ImageButton multiply = findViewById(R.id.multiply);
        multiply.setOnClickListener(this);
        ImageButton comma = findViewById(R.id.comma);
        comma.setOnClickListener(this);
        ImageButton reset = findViewById(R.id.reset);
        reset.setOnClickListener(this);
        ImageButton delete = findViewById(R.id.delete);
        delete.setOnClickListener(this);
        ImageButton result = findViewById(R.id.result);
        result.setOnClickListener(this);

    }

    public void setOne(View view) {
        processText.setText("" + processText.getText() + 1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one:
                processText.setText("" + processText.getText() + 1);
                break;
            case R.id.two:
                processText.setText("" + processText.getText() + 2);
                break;
            case R.id.three:
                processText.setText("" + processText.getText() + 3);
                break;
            case R.id.four:
                processText.setText("" + processText.getText() + 4);
                break;
            case R.id.five:
                processText.setText("" + processText.getText() + 5);
                break;
            case R.id.six:
                processText.setText("" + processText.getText() + 6);
                break;
            case R.id.seven:
                processText.setText("" + processText.getText() + 7);
                break;
            case R.id.eight:
                processText.setText("" + processText.getText() + 8);
                break;
            case R.id.nine:
                processText.setText("" + processText.getText() + 9);
                break;
            case R.id.zero:
                processText.setText("" + processText.getText() + 0);
                break;
            case R.id.comma:
                processText.setText("" + processText.getText() + ".");
                break;
            case R.id.add:
                operatorControl('+');
                break;
            case R.id.minus:
                operatorControl('-');
                break;
            case R.id.multiply:
                operatorControl('*');
                break;
            case R.id.divide:
                operatorControl('/');
                break;
            case R.id.reset:
                processText.setText("");
                resultText.setText("");
                break;
            case R.id.delete:
                if (!processText.getText().toString().equals("")) {
                    processText.setText(processText.getText().toString().substring(0, processText.getText().toString().length() - 1));
                }
                break;
            case R.id.result:
                String processExpression = processText.getText().toString();
                char lastCharacter = processExpression.charAt(processExpression.length() - 1);
                if (lastCharacter == '+' || lastCharacter == '*' || lastCharacter == '-' || lastCharacter == '/') {
                    processText.setText(processText.getText().toString().substring(0, processText.getText().toString().length() - 1));
                }
                Expression expression = new ExpressionBuilder(processText.getText().toString()).build();
                double result = expression.evaluate();
                resultText.setText("" + result);
                break;
            default:
                break;

        }
    }

    public void operatorControl(char operator) {
        char lastCharacter = processText.getText().toString().charAt(processText.getText().toString().length() - 1);
        if (lastCharacter == '+' || lastCharacter == '*' || lastCharacter == '-' || lastCharacter == '/') {
            processText.setText(processText.getText().toString().substring(0, processText.getText().toString().length() - 1));
            processText.setText("" + processText.getText() + operator);
        } else {
            processText.setText("" + processText.getText() + operator);
        }
    }
}
