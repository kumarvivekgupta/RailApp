package com.test.naimish.railapp.Activities;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.test.naimish.railapp.Fragments.PnrHistoryFragment;
import com.test.naimish.railapp.Models.UserPnrs.DeletePnrs;
import com.test.naimish.railapp.Network.UserPnrsNetwork.DeletePnrNetwork.DeletePnrApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.RailAppConstants;
import com.test.naimish.railapp.Utils.ResponseListener;
import com.test.naimish.railapp.Utils.SharedPreference;

public class PnrHistory extends SingleFragmentActivity {
    private static String TOOLBAR_TITLE = "History";

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
        return PnrHistoryFragment.newInstance();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.delete_pnr_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.delete_all_pnrs:
//                PnrHistoryFragment fragment = PnrHistoryFragment.newInstance();
//                fragment.deletePnrs();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
