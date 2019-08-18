package guide.developpement.myfragmentapp.Controllers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import guide.developpement.myfragmentapp.Controllers.Fragments.DetailFragment;
import guide.developpement.myfragmentapp.Controllers.Fragments.MainFragment;
import guide.developpement.myfragmentapp.R;

public class MainActivity extends AppCompatActivity implements MainFragment.OnButtonClickedListener {

    // 1 - Declare main and detail fragments.
    private MainFragment mMainFragment;
    private DetailFragment mDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2 - Configure and show main and detail fragments.
        this.configureAndShowMainFragment();
        this.configureAndShowDetailFragment();
    }

    // --------------
    // CallBack
    // --------------

    @Override
    public void onButtonClicked(View view) {
        // 3 - Check if detail fragment is not created or if not visible
        if (mDetailFragment == null || !mDetailFragment.isVisible()) {
            startActivity(new Intent(this, DetailActivity.class));
        }
    }

    // --------------
    // FRAGMENTS
    // --------------

    private void configureAndShowMainFragment() {
        // A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
        mMainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);

        if (mMainFragment == null) {
            // B - Create new main fragment
            mMainFragment = new MainFragment();
            // C - Add it to FrameLayout container
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_main, mMainFragment)
                    .commit();
        }
    }

    private void configureAndShowDetailFragment() {
        mDetailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        // A - We only add DetailFragment in Tablet mode (If found frame_layout_detail)
        if (mDetailFragment == null && findViewById(R.id.frame_layout_detail) != null) {
            mDetailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, mDetailFragment)
                    .commit();
        }
    }
}
