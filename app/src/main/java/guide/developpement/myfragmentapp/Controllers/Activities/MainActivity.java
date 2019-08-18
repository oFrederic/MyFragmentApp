package guide.developpement.myfragmentapp.Controllers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import guide.developpement.myfragmentapp.Controllers.Fragments.DetailFragment;
import guide.developpement.myfragmentapp.Controllers.Fragments.MainFragment;
import guide.developpement.myfragmentapp.R;

public class MainActivity extends AppCompatActivity implements MainFragment.OnButtonClickedListener {

    // Declare our two fragments.
    private MainFragment mMainFragment;
    private DetailFragment mDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configure and show it.
        this.configureAndShowMainFragment();
        this.configureAndShowDetailFragment();
    }

    // --------------
    // CallBack
    // --------------

    @Override
    public void onButtonClicked(View view) {
        // Retrieve button tag.
        int buttonTag = Integer.parseInt(view.getTag().toString());

        // Check if DetailFragment is visible (Tablet).
        if (mDetailFragment != null && mDetailFragment.isVisible()) {
            // TABLET : Update directly TextView.
            mDetailFragment.updateTextView(buttonTag);
        } else {
            // SMARTPHONE : Pass tag to the new intent that will show DetailActivity (and so DetailFragment).
            Intent i = new Intent(this, DetailActivity.class);
            i.putExtra(DetailActivity.EXTRA_BUTTON_TAG, buttonTag);
            startActivity(i);
        }
    }

    // --------------
    // FRAGMENTS
    // --------------

    private void configureAndShowMainFragment() {

        mMainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);

        if (mMainFragment == null) {
            mMainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_main, mMainFragment)
                    .commit();
        }
    }

    private void configureAndShowDetailFragment() {
        mDetailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if (mDetailFragment == null && findViewById(R.id.frame_layout_detail) != null) {
            mDetailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, mDetailFragment)
                    .commit();
        }
    }
}
