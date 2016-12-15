package vn.asiantech.training.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import vn.asiantech.training.R;
import vn.asiantech.training.models.Student;

/**
 * Created by phuong on 15/12/2016.
 */
@EFragment(R.layout.fragment_edit_student)
public class EditStudentFragment extends Fragment {

    private callEditStudentListener mCallEditStudentListener;
    private ListStudentFragment mListStudentFragment;

    @ViewById(R.id.edtName)
    EditText mEdtName;

    @ViewById(R.id.edtAge)
    EditText mEdtAge;

    @ViewById(R.id.edtSchool)
    EditText mEdtSchool;

    @ViewById(R.id.edtAddress)
    EditText mEdtAddress;

    @ViewById(R.id.imgBack)
    ImageView mImgBack;

    @ViewById(R.id.btnEdit)
    Button mBtnEdit;

    @FragmentArg
    Student mStudent;

    @FragmentArg
    int mPosition;

    @AfterViews
    void callEditStudent(){
        mEdtName.setText(mStudent.getName());
        mEdtAge.setText(mStudent.getAge());
        mEdtSchool.setText(mStudent.getSchool());
        mEdtAddress.setText(mStudent.getAddress());
        mListStudentFragment =  ListStudentFragment_.builder().build();
    }

    @Click(R.id.btnEdit)
    void editStudent(){
        Student student = new Student(mEdtName.getText().toString(), mEdtAge.getText().toString(),
                mEdtAddress.getText().toString(), mEdtSchool.getText().toString());
        mCallEditStudentListener.editStudent(student,mPosition);
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frContain, mListStudentFragment);
        ft.commit();
    }

    @Click(R.id.imgBack)
    void goBackList(){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frContain, mListStudentFragment);
        ft.commit();
    }

    public void callEditListener(callEditStudentListener listener){
        mCallEditStudentListener = listener;
    }
    public interface callEditStudentListener{
        void editStudent(Student student, int position);
    }
}
