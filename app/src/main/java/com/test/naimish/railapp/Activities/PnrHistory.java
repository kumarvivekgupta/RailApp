package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.test.naimish.railapp.Fragments.PnrHistoryFragment;
import com.test.naimish.railapp.R;

public class PnrHistory extends SingleFragmentActivity {
    private static String TOOLBAR_TITLE = "History";
    private static final PnrHistoryFragment pnrHistoryInstance=PnrHistoryFragment.newInstance();

    @Override
    protected boolean showToolbar() {
        return true;
    }

    @Override
    protected String getToolbarTitle() {
        return TOOLBAR_TITLE;
    }

    @Override
    protected int getToolbarColor() {
        return R.color.fbutton_color_pomegranate;
    }

    @Override
    protected boolean showBackButton() {
        return true;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return pnrHistoryInstance;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.delete_pnr_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all_pnrs:
                pnrHistoryInstance.deletePnrs(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
