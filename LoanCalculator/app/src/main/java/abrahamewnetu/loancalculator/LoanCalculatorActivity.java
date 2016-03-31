package abrahamewnetu.loancalculator;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.DecimalFormat;

public class LoanCalculatorActivity extends AppCompatActivity {

    private EditText nLoanAmount, nInterestRate, nLoanPeriod;
    private TextView nMonthlyPayementResult, nTotalPayementsResult;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calculator);


        nLoanAmount = (EditText) findViewById(R.id.loan_amount);
        nInterestRate = (EditText) findViewById(R.id.interest_rate);
        nLoanPeriod = (EditText) findViewById(R.id.loan_period);
        nMonthlyPayementResult = (TextView) findViewById(R.id.monthly_payment_result);
        nTotalPayementsResult = (TextView) findViewById(R.id.total_payments_result);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    public void showLoanPayments(View clickButton) {
        double loanAmount = Integer.parseInt(nLoanAmount.getText().toString());
        double interestRate = (Integer.parseInt(nInterestRate.getText().toString()));
        double loanPeriod = Integer.parseInt(nLoanPeriod.getText().toString());
        double r = interestRate / 1200;
        double r1 = Math.pow(r + 1, loanPeriod);

        double monthlyPayment = (double) ((r + (r / r1 - 1)) + loanAmount);
        double totalPayment = monthlyPayment * loanPeriod;

        nMonthlyPayementResult.setText(new DecimalFormat("##.##").format(monthlyPayment));
        nTotalPayementsResult.setText(new DecimalFormat("##.##").format(totalPayment));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loan_calculator, menu);
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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "LoanCalculator Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://abrahamewnetu.loancalculator/http/host/path")
        );
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "LoanCalculator Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://abrahamewnetu.loancalculator/http/host/path")
        );
    }
}
