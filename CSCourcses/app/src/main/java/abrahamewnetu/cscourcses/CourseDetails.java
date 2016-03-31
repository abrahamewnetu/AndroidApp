package abrahamewnetu.cscourcses;

/**
 * Created by abrahamewnetu on 03/01/16.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class CourseDetails  extends Fragment {

    public static CourseDetails newInstance(int index){
        CourseDetails courseDetails = new CourseDetails();
        Bundle args = new Bundle();
        args.putInt("index", index);
        courseDetails.setArguments(args);
        return courseDetails;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView scrollView = new ScrollView(getActivity());
        TextView text = new TextView(getActivity());
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4,
                getActivity().getResources().getDisplayMetrics());
        text.setPadding(padding,padding,padding,padding);
        text.setFontFeatureSettings("30sp");
        scrollView.addView(text);
        text.setText(Courses.COURSES_INFO[getShowIndex()]);
        return scrollView;

    }

    public int getShowIndex(){
        return getArguments().getInt("index", 0);
    }
}