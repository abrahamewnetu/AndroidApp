package abrahamewnetu.cscourcses;

/**
 * Created by abrahamewnetu on 03/01/16.
 */
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CourseFragment extends ListFragment {
    boolean mDualPane;
    int position = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> connectArrayToListView = new
                ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_activated_1,
                Courses.COURSES);
        setListAdapter(connectArrayToListView);
        View detailsFrame = getActivity().findViewById(R.id.details);
        mDualPane = (detailsFrame != null &&
                detailsFrame.getVisibility() == View.VISIBLE);
        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("curChoice", 0);
        }
        if (mDualPane) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(position);
        }
    }

    void showDetails(int index) {
        position = index;
        getListView().setItemChecked(index, true);
        if (mDualPane) {
            CourseDetails courses = (CourseDetails)
                    getFragmentManager().findFragmentById(R.id.details);
            if (courses == null || courses.getShowIndex() != index) {
                courses = CourseDetails.newInstance(index);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.details, courses);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), CourseActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", position);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        showDetails(position);
    }

}