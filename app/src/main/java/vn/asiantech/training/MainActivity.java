package vn.asiantech.training;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DoQuizzFragment.OnFragmentInteractionListener {
    public ArrayList<QuizzObj> sQuizzArray = new ArrayList<QuizzObj>();
    private Button mBtnStartQuizz;
    private Button mBtnFinish;
    private android.support.v4.app.FragmentTransaction mFragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        insertData();
        init();
        mBtnStartQuizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBtnStartQuizz.setVisibility(View.INVISIBLE);
                mBtnFinish.setVisibility(View.INVISIBLE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                mFragmentTransaction = fragmentManager.beginTransaction();
                DoQuizzFragment fragment = new DoQuizzFragment();
                mFragmentTransaction.add(R.id.activity_main, fragment, "QuizzDo").commit();
            }
        });
    }

    private void insertData() {
        sQuizzArray.add(new QuizzObj("I ............Louisiana state University.", "am attending", "attend", "was attending", "attended", "am attending"));
        sQuizzArray.add(new QuizzObj("He fell down when he ............towards the church.", "run", "runs", "was running", "had run", "was running"));
        sQuizzArray.add(new QuizzObj("We ............there when our father died.", "still lived", "lived still", "was still living", "were still living", "were still living"));
        sQuizzArray.add(new QuizzObj("They ............pingpong when their father comes back home.", "will play", "will be playing", "play", "would play", "will be playing"));
        sQuizzArray.add(new QuizzObj("By Christmas, I.............for you for 6 months.", "Shall have been working", "shall work", "have been working", "shall be working", "Shall have been working"));
        sQuizzArray.add(new QuizzObj("I............in the room now.", "am being", "was being", "have been being", "am", "am"));
        sQuizzArray.add(new QuizzObj("I.............to New york three times this year.", "have been", "was", "were", "had been", "have been"));
        sQuizzArray.add(new QuizzObj("I will come and see you before I.............for America.", "leave", "will leave", "had left", "shall leave", "leave"));
        sQuizzArray.add(new QuizzObj("The little girl asked wha.............to her friend.", "has happened", "happened", "had happened", "would have been happened", "had happened"));
        sQuizzArray.add(new QuizzObj("John ............a book when I saw him.", "is reading", "read", "was reading", "reading", "was reading"));
    }

    private void init() {
        mBtnStartQuizz = (Button) findViewById(R.id.btnStartQuizz);
        mBtnFinish = (Button) findViewById(R.id.btnFinishActivity);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
