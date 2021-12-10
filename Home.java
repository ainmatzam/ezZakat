package net.ain.ezakat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity implements View.OnClickListener {

    EditText weight, currentprice;
    RadioButton keepbtn, wearbtn;
    Button btnCount;
    TextView outputzakat, outputtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        weight = (EditText) findViewById(R.id.weight);
        currentprice = (EditText) findViewById(R.id.currentprice);
        keepbtn = (RadioButton) findViewById(R.id.keepbtn);
        wearbtn = (RadioButton) findViewById(R.id.wearbtn);
        btnCount = (Button) findViewById(R.id.btnCount);
        outputzakat = (TextView) findViewById(R.id.outputzakat);
        outputtotal = (TextView) findViewById(R.id.outputtotal);


        btnCount.setOnClickListener(this);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (weight.getText().toString().length()==0){
                    weight.setError("Enter gold weight");
                }
                else if (currentprice.getText().toString().length()==0){
                    currentprice.setError("Enter current price");
                }

            }
        });

    }


    @Override
    public void onClick(View v) {



                double countweight = Double.parseDouble(weight.getText().toString());
                double countprice = Double.parseDouble(currentprice.getText().toString());

                if(keepbtn.isChecked()){
                    double zakat = (countweight-85)  * countprice;
                    double total = zakat * 0.025;
                    outputzakat.setText("RM" + zakat);
                    outputtotal.setText("RM" + total);
                }
                else{
                    double zakat = (countweight-200)  * countprice;
                    double total = zakat * 0.025;
                    outputzakat.setText("RM" + zakat);
                    outputtotal.setText("RM" + total);
                }


        }
    }

