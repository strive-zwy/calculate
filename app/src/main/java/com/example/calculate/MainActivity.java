package com.example.calculate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_view;

    private boolean isDian = false; //标记是否输入过点
    private boolean isRestart = false;//标记是否开始下一次计算
    private String tempStr = "";//临时存储正在输入的字符串
    private List<String> list = new ArrayList<>();//存储将要计算的合集


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_view = findViewById(R.id.et_view);

        Button btn_0 = findViewById(R.id.btn_0);
        Button btn_1 = findViewById(R.id.btn_1);
        Button btn_2 = findViewById(R.id.btn_2);
        Button btn_3 = findViewById(R.id.btn_3);
        Button btn_4 = findViewById(R.id.btn_4);
        Button btn_5 = findViewById(R.id.btn_5);
        Button btn_6 = findViewById(R.id.btn_6);
        Button btn_7 = findViewById(R.id.btn_7);
        Button btn_8 = findViewById(R.id.btn_8);
        Button btn_9 = findViewById(R.id.btn_9);
        Button btn_dian = findViewById(R.id.btn_dian);

        Button btn_del = findViewById(R.id.btn_del);
        Button btn_c = findViewById(R.id.btn_c);

        Button btn_jia = findViewById(R.id.btn_jia);
        Button btn_jian = findViewById(R.id.btn_jian);
        Button btn_cheng = findViewById(R.id.btn_cheng);
        Button btn_chu = findViewById(R.id.btn_chu);

        Button btn_deng = findViewById(R.id.btn_deng);

        //添加点击事件
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_dian.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_jia.setOnClickListener(this);
        btn_jian.setOnClickListener(this);
        btn_cheng.setOnClickListener(this);
        btn_chu.setOnClickListener(this);
        btn_deng.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        StringBuilder input;
        if (isRestart) {
            input = new StringBuilder();
//            isRestart = false;
        } else {
            input = new StringBuilder(et_view.getText().toString());
        }
        switch (v.getId()){
            case R.id.btn_0:
                isRestart = false;
                if (input.toString().equals("") || input.toString().equals("0")) {
                    et_view.setText("");
                }else {
                    input.append("0");
                    tempStr = tempStr + "0";
                    et_view.setText(input);
                }
                break;
            case R.id.btn_1:
                isRestart = false;
                input.append("1");
                tempStr = tempStr + "1";
                et_view.setText(input);
                break;
            case R.id.btn_2:
                isRestart = false;
                input.append("2");
                tempStr = tempStr + "2";
                et_view.setText(input);
                break;
            case R.id.btn_3:
                isRestart = false;
                input.append("3");
                tempStr = tempStr + "3";
                et_view.setText(input);
                break;
            case R.id.btn_4:
                isRestart = false;
                input.append("4");
                tempStr = tempStr + "4";
                et_view.setText(input);
                break;
            case R.id.btn_5:
                isRestart = false;
                input.append("5");
                tempStr = tempStr + "5";
                et_view.setText(input);
                break;
            case R.id.btn_6:
                isRestart = false;
                input.append("6");
                tempStr = tempStr + "6";
                et_view.setText(input);
                break;
            case R.id.btn_7:
                isRestart = false;
                input.append("7");
                tempStr = tempStr + "7";
                et_view.setText(input);
                break;
            case R.id.btn_8:
                isRestart = false;
                input.append("8");
                tempStr = tempStr + "8";
                et_view.setText(input);
                break;
            case R.id.btn_9:
                isRestart = false;
                input.append("9");
                tempStr = tempStr + "9";
                et_view.setText(input);
                break;
            case R.id.btn_dian:
                if (input.length() == 0) {
                    break;
                }
                if (isSymbol(input)) {
                    break;
                }
                if (!isDian) {
                    input.append(".");
                    tempStr = tempStr + ".";
                    et_view.setText(input);
                }
                isDian = true;
                break;
            case R.id.btn_c:
                appRestart();
                return;
            case R.id.btn_jia:
                if (input.length() == 0) {
                    break;
                }
                list.add(tempStr);
                list.add("＋");
                tempStr = "";
                isDian = false;
                if (isSymbol(input)) {
                    break;
                }
                input.append("＋");
                et_view.setText(input);
                break;
            case R.id.btn_jian:
                if (input.length() == 0) {
                    break;
                }
                list.add(tempStr);
                list.add("－");
                tempStr = "";
                isDian = false;
                if (isSymbol(input)) {
                    break;
                }
                input.append("－");
                et_view.setText(input);
                break;
            case R.id.btn_cheng:
                if (input.length() == 0) {
                    break;
                }
                list.add(tempStr);
                list.add("×");
                tempStr = "";
                isDian = false;
                if (isSymbol(input)) {
                    break;
                }
                input.append("×");
                et_view.setText(input);
                break;
            case R.id.btn_chu:
                if (input.length() == 0) {
                    break;
                }
                list.add(tempStr);
                list.add("÷");
                tempStr = "";
                isDian = false;
                if (isSymbol(input)) {
                    break;
                }
                input.append("÷");
                et_view.setText(input);
                break;
            case R.id.btn_deng:
                if (input.length() == 0) {
                    break;
                }
                if (list.size() == 0) {
                    et_view.setText(input);
                    break;
                }
                isDian = false;
                isRestart = true;
                if (isSymbol(input)) {
                    break;
                }
                list.add(tempStr);
                input.append("＝");
                input.append("\n");
                input.append(getResult(list));
                et_view.setText(input);
                tempStr = "";
                list.clear();
                break;
            case R.id.btn_del:
                if (input.toString().equals("")) {
                    appRestart();
                    break;
                }
                if (!isSymbol(input)) {
                    tempStr = tempStr.length() == 0 ?  "" : tempStr.substring(0,tempStr.length()-1);
                }else {
                    list.remove(list.size()-1);
                    tempStr = list.get(list.size()-1);
                    list.remove(list.size()-1);
                }
                if (input.substring(input.length()-1,input.length()).equals(".")) isDian = false;
                input = new StringBuilder(input.substring(0,input.length()-1));
                et_view.setText(input);
                break;
            default:
                break;
        }
        et_view.setSelection(input.length());
    }

    private void appRestart() {
        isDian = false;
        isRestart = false;
        tempStr = "";
        list.clear();
        et_view.setText("");
    }

    //判断最后一位是否是字符
    private boolean isSymbol(StringBuilder input){
        String s = input.substring(input.length()-1,input.length());
        if (s.equals("＋")) {
            return true;
        }
        if (s.equals("－")) {
            return true;
        }
        if (s.equals("×")) {
            return true;
        }
        if (s.equals("÷")) {
            return true;
        }
        if (s.equals("＝")) {
            return true;
        }
        return false;
    }

    private String getResult(List<String> list){
        if (list.size() == 1) {
            String s = list.get(0).substring(list.get(0).length()-9);
            if (s.equals(".00000000")) {
                return list.get(0).substring(0,list.get(0).length()-9);
            }
            return list.get(0);
        }else {
            for (int i = 0; i < list.size();i++) {
                if (list.get(i).equals("×") || list.get(i).equals("÷")) {
                    getString(list, i);
                }
            }
            for (int i = 0; i < list.size();i++) {
                if (list.get(i).equals("＋") || list.get(i).equals("－")) {
                    getString(list, i);
                }
            }
        }
        return getResult(list);
    }

    private void getString(List<String> list, int i) {
        String res = getRes(list.get(i-1),list.get(i+1),list.get(i));
        list.remove(i-1);
        list.remove(i-1);
        list.remove(i-1);
        list.add(i-1,res);
        getResult(list);
    }

    private String getRes(String numStr1,String numStr2,String symbol){
        double n1 = Double.parseDouble(numStr1);
        double n2 = Double.parseDouble(numStr2);
        double res = 0;
        switch (symbol){
            case "×":
                res = n1 * n2;
                break;
            case "÷":
                res = n1 / n2;
                break;
            case "＋":
                res = n1 + n2;
                break;
            case "－":
                res = n1 - n2;
                break;
        }
        BigDecimal rr = new BigDecimal(res);
        DecimalFormat df = new DecimalFormat("###############0.00000000#");
        String s = df.format(rr);
        return String.valueOf(s);
    }

}
