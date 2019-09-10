package com.example.voicecalculater;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.voicecalculater.Utils.Utils;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.List;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    TextView formulaTxt, resultTxt;
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_plus, btn_minus, btn_multiply, btn_devide, btn_mod, btn_equal, btn_decimal, btn_plus_minus, btn_root, btn_clear, btn_start_bracket, btn_end_bracket, btn_pi;
    ImageButton voiceBtn, btn_backspace;

    private static final int REQ_CODE_SPEECH_INPUT = 100;
    PackageManager packageManager;
    int flag = 0;

    // Represent whether the lastly pressed key is numeric or not
    private boolean lastNumeric = true;
    // Represent that current state is in error or not
    private boolean stateError = false;
    // If true, do not allow to add another DOT
    private boolean lastDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        init();

    }
    // TODO :- Methods

    private void init()
    {
        //register IDs
        btn_0 = findViewById(R.id.btn_0);
        btn_0.setOnClickListener(this);
        btn_1 = findViewById(R.id.btn_1);
        btn_1.setOnClickListener(this);
        btn_2 = findViewById(R.id.btn_2 );
        btn_2 .setOnClickListener(this);
        btn_3 = findViewById(R.id.btn_3);
        btn_3.setOnClickListener(this);
        btn_4 = findViewById(R.id.btn_4);
        btn_4.setOnClickListener(this);
        btn_5 = findViewById(R.id.btn_5);
        btn_5.setOnClickListener(this);
        btn_6 = findViewById(R.id.btn_6);
        btn_6.setOnClickListener(this);
        btn_7 = findViewById(R.id.btn_7);
        btn_7.setOnClickListener(this);
        btn_8 = findViewById(R.id.btn_8);
        btn_8.setOnClickListener(this);
        btn_9 = findViewById(R.id.btn_9);
        btn_9.setOnClickListener(this);

        btn_plus = findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(this);
        btn_minus = findViewById(R.id.btn_minus);
        btn_minus.setOnClickListener(this);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_multiply.setOnClickListener(this);
        btn_devide = findViewById(R.id.btn_devide);
        btn_devide.setOnClickListener(this);
        btn_decimal = findViewById(R.id.btn_decimal);
        btn_decimal.setOnClickListener(this);
        btn_equal = findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(this);
        btn_mod = findViewById(R.id.btn_mod);
        btn_mod.setOnClickListener(this);
        btn_plus_minus = findViewById(R.id.btn_plus_minus);
        btn_plus_minus.setOnClickListener(this);
        btn_root = findViewById(R.id.btn_root);
        btn_root.setOnClickListener(this);
        btn_start_bracket = findViewById(R.id.btn_start_bracket);
        btn_start_bracket.setOnClickListener(this);
        btn_end_bracket = findViewById(R.id.btn_end_bracket);
        btn_end_bracket.setOnClickListener(this);
        btn_pi = findViewById(R.id.btn_pi);
        btn_pi.setOnClickListener(this);


        btn_backspace = findViewById(R.id.btn_backspace);
        btn_backspace.setOnClickListener(this);
        btn_clear = findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(this);


        formulaTxt = findViewById(R.id.formula);
        resultTxt= findViewById(R.id.result);

        voiceBtn = findViewById(R.id.voiceBtn);
        voiceBtn.setOnClickListener(this);

        Intent intent = getIntent();
        Integer isVoice = intent.getIntExtra("isVoice", 0);
        if (isVoice == 0){
            voiceBtn.setVisibility(View.GONE);
        }else{
            voiceBtn.setVisibility(View.VISIBLE);
        }


        Utils.changeStatusBarColor(getWindow());
        packageManager = getPackageManager();

        List<ResolveInfo> activities = packageManager.queryIntentActivities(new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if (activities.size() == 0) {
            // No Text Recognize
        }
    }


    private void startVoiceRecognitionActivity()
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Voice searching...");
        startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String change = result.get(0).toLowerCase();
                    change = change.replace("x".toLowerCase(), "*");
                    change = change.replace("add".toLowerCase(), "+");
                    change = change.replace("sub".toLowerCase(), "-");
                    change = change.replace("plus".toLowerCase(), "+");
                    change = change.replace("minus".toLowerCase(), "-");
                    change = change.replace("times".toLowerCase(), "*");
                    change = change.replace("into".toLowerCase(), "*");
                    change = change.replace("in2".toLowerCase(), "*");
                    change = change.replace("multiply by".toLowerCase(), "*");
                    change = change.replace("multiply".toLowerCase(), "*");
                    change = change.replace("divide by".toLowerCase(), "/");
                    change = change.replace("by".toLowerCase(), "/");
                    change = change.replace("divided".toLowerCase(), "/");
                    change = change.replace("divide".toLowerCase(), "/");

                    change = change.replace("equals".toLowerCase(), "=");
                    change = change.replace("equal".toLowerCase(), "=");
                    change = change.replace("Pi".toLowerCase(), "3.14");
                    change = change.replace("negative".toLowerCase(), "-");
                    change = change.replace("cross".toLowerCase(), "*");
                    change = change.replace("raised to".toLowerCase(), "^");
                    change = change.replace("raise to".toLowerCase(), "^");
                    change = change.replace("raise".toLowerCase(), "^");
                    change = change.replace("to".toLowerCase(), "2");
                    change = change.replace("mod".toLowerCase(), "%");

                    change = change.replace("cubed".toLowerCase(), "^3");
                    change = change.replace("cube".toLowerCase(), "^3");

                    // Symbol
                    change = change.replace("Point".toLowerCase(), ".");
                    change = change.replace("Comma".toLowerCase(), ",");
                    change = change.replace("Question mark".toLowerCase(), "?");
                    change = change.replace("Exclamation point".toLowerCase(), "!");
                    change = change.replace("Exclamation mark".toLowerCase(), "!");
                    change = change.replace("Equals to".toLowerCase(), "=");
                    change = change.replace("At the rate".toLowerCase(), "@");
                    change = change.replace("Forward slash".toLowerCase(), "/");
                    change = change.replace("Backward slash".toLowerCase(), "\\");
                    change = change.replace("Backslash".toLowerCase(), "\\");
                    change = change.replace("Smiley face".toLowerCase(), ":-)");
                    change = change.replace("Sad face".toLowerCase(), ":-(");
                    change = change.replace("Percent".toLowerCase(), "%");
                    change = change.replace("dot".toLowerCase(), ".");
                    change = change.replace("Ampersand".toLowerCase(), "&");
                    change = change.replace("Asterisk".toLowerCase(), "*");
                    change = change.replace("Apostrophe".toLowerCase(), "‘");
                    change = change.replace("Colon".toLowerCase(), ":");
                    change = change.replace("Open bracket".toLowerCase(), "[");
                    change = change.replace("Close bracket".toLowerCase(), "]");
                    change = change.replace("Open parenthesis".toLowerCase(), "(");
                    change = change.replace("Close parenthesis".toLowerCase(), ")");

                    change = change.replace("Square root of".toLowerCase(), "√");
                    change = change.replace("Cubic root of".toLowerCase(), "3√");

                    String noSpaceStr = change.replaceAll("\\s", "");
                    formulaTxt.setText(noSpaceStr);

                    onEqual();
                }
                break;
            }
        }
    }

    /**
     * Logic to calculate the solution.
     */
    private void onEqual()
    {
        // If the current state is error, nothing to do.
        // If the last input is a number only, solution can be found.
        if (lastNumeric && !stateError) {
            // Read the expression
            String finalStr = (String) formulaTxt.getText();

            finalStr = finalStr.replace("3√".toLowerCase(), "cbrt");
            finalStr = finalStr.replace("√".toLowerCase(), "sqrt");
            finalStr = finalStr.replace("π", "3.14");
            finalStr = finalStr.replaceAll("\\s", "");

            // Create an Expression (A class from exp4j library)
            try {
                Expression expression = null;
                try {
                    expression = new ExpressionBuilder(finalStr).build();
                    double result = expression.evaluate();
                    String finalResult = Double.toString(result);
                    if (finalResult.contains(".0")){
                        finalResult = finalResult.replace(".0","");
                    }
                    resultTxt.setText(finalResult);
                } catch (Exception e) {
                    resultTxt.setText("Invalid Expression");
                }
                lastDot = true; // Result contains a dot
            } catch (ArithmeticException ex) {
                // Display an error message
                resultTxt.setText("Invalid Expression");
                stateError = true;
                lastNumeric = false;
            }
        }
    }



    // TODO :- Button Click
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_0:
                addNumber(0);
                break;
            case R.id.btn_1:
                addNumber(1);
                break;
            case R.id.btn_2:
                addNumber(2);
                break;
            case R.id.btn_3:
                addNumber(3);
                break;
            case R.id.btn_4:
                addNumber(4);
                break;
            case R.id.btn_5:
                addNumber(5);
                break;
            case R.id.btn_6:
                addNumber(6);
                break;
            case R.id.btn_7:
                addNumber(7);
                break;
            case R.id.btn_8:
                addNumber(8);
                break;
            case R.id.btn_9:
                addNumber(9);
                break;
            case R.id.btn_decimal:
                addDecimalPoint();
                break;
            case R.id.btn_plus_minus:
                addPlusMinus();
                break;
            case R.id.btn_plus:
                addOperation("+");
                break;
            case R.id.btn_minus:
                addOperation("-");
                break;
            case R.id.btn_multiply:
                addOperation("*");
                break;
            case R.id.btn_devide:
                addOperation("/");
                break;
            case R.id.btn_start_bracket:
                addBracketValue("(");
                break;
            case R.id.btn_end_bracket:
                addBracketValue(")");
                break;
            case R.id.btn_mod:
                addOperation("%");
                break;
            case R.id.btn_pi:
                addPiValue();
                break;
            case R.id.btn_root:
                addOperation("√");
                break;
            case R.id.btn_backspace:
                clickToBackSpace();
                break;
            case R.id.btn_equal:
                onEqual();
                break;
            case R.id.btn_clear:
                formulaTxt.setText("");
                resultTxt.setText("");
                break;
            case R.id.voiceBtn:
                startVoiceRecognitionActivity();
                break;
        }
    }

    public void addNumber(Integer value)
    {
        formulaTxt.setText(formulaTxt.getText() + value.toString());
    }

    public void addDecimalPoint()
    {
        if (formulaTxt.getText().length() == 0){
            formulaTxt.setText(formulaTxt.getText() + "0.");
        }
        else if (!getLastCharacterofString().equals(".")){
            if (isLastCharacterIsDigit()){
                formulaTxt.setText(formulaTxt.getText() + ".");
            }
            else{
                formulaTxt.setText(formulaTxt.getText() + "0.");
            }
        }
    }

    public void addOperation(String value)
    {
        if (formulaTxt.getText().length() > 0){
            replaceLastCharacter();
        }
        formulaTxt.setText(formulaTxt.getText() + value);
    }

    public void addBracketValue(String value)
    {
        formulaTxt.setText(formulaTxt.getText() + value);
    }

    public void addPiValue(){
        String lastStr = getLastCharacterofString();
        if (!lastStr.equals("π")){
            formulaTxt.setText(formulaTxt.getText() + "π");
        }
    }

    public void addPlusMinus(){

        if (formulaTxt.getText().length() == 0){
            formulaTxt.setText(formulaTxt.getText() + "-");
        }
        else
        {
            String lastStr = getLastCharacterofString();
            if (lastStr.equals("-")){
                removeLastCharacterofString();
                formulaTxt.setText(formulaTxt.getText() + "+");
            }else if (lastStr.equals("+")){
                removeLastCharacterofString();
                formulaTxt.setText(formulaTxt.getText() + "-");
            }
            else{
                formulaTxt.setText(formulaTxt.getText() + "-");
            }
        }
    }

    public void clickToBackSpace(){

        removeLastCharacterofString();
        resultTxt.setText("");
    }

    public String getLastCharacterofString()
    {
        String str = (String) formulaTxt.getText();
        return String.valueOf(str.charAt(str.length() - 1));
    }

    public void removeLastCharacterofString()
    {
        String str = (String) formulaTxt.getText();
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length()-1);;
        }
        formulaTxt.setText(str);
    }

    public void replaceLastCharacter()
    {
        switch (getLastCharacterofString()){
            case "+":
                removeLastCharacterofString();
                break;
            case "-":
                removeLastCharacterofString();
                break;
            case "*":
                removeLastCharacterofString();
                break;
            case "/":
                removeLastCharacterofString();
                break;
            case "√":
                removeLastCharacterofString();
                break;
            case "%":
                removeLastCharacterofString();
                break;
        }
    }

    public Boolean isLastCharacterIsDigit(){
        String lastStr = getLastCharacterofString();

        if (lastStr.equals("0") || lastStr.equals("1") || lastStr.equals("2") || lastStr.equals("3") || lastStr.equals("4") || lastStr.equals("5") || lastStr.equals("6") || lastStr.equals("7") || lastStr.equals("8") || lastStr.equals("9")){
            return true;
        }
        return false;
    }

}
