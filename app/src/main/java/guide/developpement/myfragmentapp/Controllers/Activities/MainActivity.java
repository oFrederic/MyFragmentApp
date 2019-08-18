package guide.developpement.myfragmentapp.Controllers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import guide.developpement.myfragmentapp.Controllers.Fragments.MainFragment;
import guide.developpement.myfragmentapp.R;

public class MainActivity extends AppCompatActivity implements MainFragment.OnButtonClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // --------------
    // CallBack
    // --------------

    @Override
    public void onButtonClicked(View view) {
        Log.e(getClass().getSimpleName(), "Button clicked !");
    }
}
