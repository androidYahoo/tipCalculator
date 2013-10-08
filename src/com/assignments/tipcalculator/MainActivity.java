package com.assignments.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public EditText etAmount;
	public TextView tvFinalAmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAmount = (EditText) findViewById(R.id.etAmount);
        tvFinalAmt = (TextView) findViewById(R.id.tvFinalAmt);
        etAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            	tvFinalAmt = (TextView) findViewById(R.id.tvFinalAmt);
    	    	tvFinalAmt.setText("");
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
               
            }
        });
    }
            

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void calculateTip(View v){
    	Float amtValue = null;
    	try {
    		amtValue = Float.valueOf(etAmount.getText().toString());
    	}
    	catch(NumberFormatException e){
    		Toast.makeText(this,"Invalid Amount", Toast.LENGTH_SHORT).show();
    	}
    	if(amtValue !=null){
	    	double tipAmt = 0.0;
	    	switch(v.getId()) {	
	    		case R.id.btnTenPercentage:
	    			tipAmt = amtValue * 0.1;
	    			break;
	    		case R.id.btnFifteenPercentage:
	    			tipAmt = amtValue * 0.15;
	    			break;
	    		case R.id.btnTwentyPercentage:
	    			tipAmt = amtValue * 0.2;
	    			break;
	    		default:	
	    		throw new RuntimeException("Unknown Button");
	    	}
	    	tvFinalAmt = (TextView) findViewById(R.id.tvFinalAmt);
	    	tvFinalAmt.setText(Double.toString(tipAmt));
    	}
    }
}
