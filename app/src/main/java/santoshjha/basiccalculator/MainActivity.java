package santoshjha.basiccalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText input;
    private TextView result;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnDot;
    private Button btnC;
    private Button btnBackSpace;
//    private Button btnBraces;
    private Button btnPercentage;
    private Button btnDiv;
    private Button btnMul;
    private Button btnSub;
    private Button btnAdd;
    private Button btnEqual;
//    private Button btnSign;

    private boolean isNumber;
    private boolean lastDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseButtons();
        setOnClick();

        input.setRawInputType(InputType.TYPE_NULL);
        input.addTextChangedListener(textWatcher);
    }

    void initialiseButtons(){
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnC = findViewById(R.id.btnC);
        btnDot = findViewById(R.id.btnDot);
        btnBackSpace = findViewById(R.id.btnBackSpace);
//        btnBraces = findViewById(R.id.btnBraces);

        btnPercentage = findViewById(R.id.btnPercentage);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMul);
        btnSub = findViewById(R.id.btnSub);
        btnAdd = findViewById(R.id.btnAdd);
        btnEqual = findViewById(R.id.btnEqual);
//        btnSign = findViewById(R.id.btnSign);

        result=findViewById(R.id.result);
        input=findViewById(R.id.input);
    }

    void setOnClick(){
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnPercentage.setOnClickListener(this);
//        btnBraces.setOnClickListener(this);
        btnBackSpace.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnMul.setOnClickListener(this);
//        btnSign.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
    }

    TextWatcher textWatcher =new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            calculate(false);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void onClick(View v) {
        int ID=v.getId();
        switch (ID){
            case R.id.btn0:
                input.append("0");
                isNumber=true;
                lastDot=false;
                break;
            case R.id.btn1:
                input.append("1");
                isNumber=true;
                lastDot=false;
                break;
            case R.id.btn2:
                input.append("2");
                isNumber=true;
                lastDot=false;
                break;
            case R.id.btn3:
                input.append("3");
                isNumber=true;
                lastDot=false;
                break;
            case R.id.btn4:
                input.append("4");
                isNumber=true;
                lastDot=false;
                break;
            case R.id.btn5:
                input.append("5");
                isNumber=true;
                lastDot=false;
                break;
            case R.id.btn6:
                input.append("6");
                isNumber=true;
                lastDot=false;
                break;
            case R.id.btn7:
                input.append("7");
                isNumber=true;
                lastDot=false;
                break;
            case R.id.btn8:
                input.append("8");
                isNumber=true;
                lastDot=false;
                break;
            case R.id.btn9:
                input.append("9");
                isNumber=true;
                lastDot=false;
                break;
            case R.id.btnDot:
                if(isNumber && !lastDot){
                    input.append(".");
                    isNumber=false;
                    lastDot=true;
                }
                break;
            case R.id.btnC:
                input.getText().clear();
                result.setText("");
                lastDot=false;
                isNumber=false;
                break;
            case R.id.btnPercentage:
                if(!input.getText().toString().isEmpty() && isNumber){
                    input.append("%");
                }
                break;
            case R.id.btnBackSpace:
                if(input.getText().toString().isEmpty()){
                    input.getText().clear();
                }
                else{
                    String equation= String.valueOf(input.getText());
                    input.getText().delete(equation.length()-1,equation.length());
                }
                break;
            case R.id.btnAdd:
                if(isNumber && !lastDot && !endsWithOperator()){
                    input.append("+");
                }
                isNumber=false;
                lastDot=false;
                break;
            case R.id.btnSub:
                if(isNumber && !lastDot &&!endsWithOperator()) {
                    input.append("-");
                }
                isNumber=false;
                lastDot=false;
                break;
            case R.id.btnDiv:
                if(isNumber && !lastDot &&!endsWithOperator()) {
                    input.append("/");
                }
                isNumber=false;
                lastDot=false;
                break;
            case R.id.btnMul:
                if(isNumber && !lastDot && !endsWithOperator()) {
                    input.append("*");
                }
                isNumber=false;
                lastDot=false;
                break;
//            case R.id.btnBraces:
//                To be done later
//                break;
//            case R.id.btnSign:
//                To be done later
//                break;
            case R.id.btnEqual:
                calculate(true);
                break;
        }
    }

    public void calculate(boolean isEqualClicked){
        try{
            if(!input.getText().toString().isEmpty()&& !endsWithOperator()){
                Expression expression= new ExpressionBuilder(input.getText().toString()).build();
                double resultExpression=expression.evaluate();

                if(isEqualClicked){
                    input.setText(String.valueOf(resultExpression));
                    result.setText("");
                }
                else{
                    result.setText(String.valueOf(resultExpression));
                }
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Something Wrong Happened",Toast.LENGTH_LONG).show();
        }
    }

    public boolean endsWithOperator(){
        return input.getText().toString().endsWith("+") || input.getText().toString().endsWith("-") ||
                input.getText().toString().endsWith("*") || input.getText().toString().endsWith("/") ||
                input.getText().toString().endsWith("%");
    }
}