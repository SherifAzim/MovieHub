package com.etiennelawlor.moviehub.presentation.televisionshowdetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.etiennelawlor.moviehub.R;
import com.etiennelawlor.moviehub.presentation.models.TelevisionShowPresentationModel;

import butterknife.ButterKnife;

public class TelevisionShowDetailsActivity extends AppCompatActivity {

    // region Constants
    protected static final String KEY_TELEVISION_SHOW = "TELEVISION_SHOW";
    // endregion

    // region Lifecycle Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_television_show_details);
        ButterKnife.bind(this);

        Fragment fragment = getSupportFragmentManager().findFragmentById(android.R.id.content);
        if (fragment == null) {
            fragment = TelevisionShowDetailsFragment.newInstance(getIntent().getExtras());
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .replace(android.R.id.content, fragment, "")
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .attach(fragment)
                    .commit();
        }
    }
    // endregion

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition();
//                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Use factory methods for creating Intents
    public static Intent createIntent(Context context, TelevisionShowPresentationModel televisionShow){
        Intent intent = new Intent(context, TelevisionShowDetailsActivity.class);
        intent.putExtra(KEY_TELEVISION_SHOW, televisionShow);
        return intent;
    }
}
