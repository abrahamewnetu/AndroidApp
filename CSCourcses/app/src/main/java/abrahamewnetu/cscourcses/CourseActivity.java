package abrahamewnetu.cscourcses;

/**
 * Created by abrahamewnetu on 03/01/16.
 */
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

public class CourseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }
        if(savedInstanceState == null){
            CourseDetails course = new CourseDetails();
            course.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content, course).commit();
        }
    }
}