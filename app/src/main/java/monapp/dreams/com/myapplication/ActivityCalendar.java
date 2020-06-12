package monapp.dreams.com.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.CalendarView;

import java.util.Calendar;
import java.util.Date;

public class ActivityCalendar extends AppCompatActivity {

    private Date date;
    private String dateIntent;
    private final static int REQUEST_CODE_1 = 1;
    CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        calendarView = findViewById(R.id.calendarView);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                date = new Date((month+1)+"/"+dayOfMonth+"/"+year);
                Log.d("date",date.toString());
                dateIntent = date.getDate()+"-"+(date.getMonth()+1)+"-"+(date.getYear()+1900);
            }
        });
    }

    public void validationDate(View v){

        Intent intent = new Intent();
        intent.putExtra("date", dateIntent);
        setResult(RESULT_OK,intent);
        finish();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}