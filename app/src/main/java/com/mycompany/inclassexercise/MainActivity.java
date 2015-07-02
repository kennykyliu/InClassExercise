package com.mycompany.inclassexercise;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.inclassexercise.MESSAGE";
    private static final String TAG = "Kenny";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** Called when the user clicks the Factorial button */
    public void getFactorial(View view) {
        Intent intent = new Intent(this, DisaplyResultActivity.class);
        EditText editText = (EditText) findViewById(R.id.inputNumber);

        int userInput = Integer.parseInt(editText.getText().toString());
        long factorialResult = 1;

        for (long i = 1; i <= userInput; i++) {
            Log.i(TAG, "i = " + i);
            factorialResult *= i;
        }
        Log.i(TAG, "Result = " + factorialResult);
        String message = String.valueOf(factorialResult);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
