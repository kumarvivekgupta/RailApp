package com.test.naimish.railapp.Utils;

import java.util.ArrayList;

/**
 * Created by naimish on 4/1/2018.
 */

public interface RailAppConstants {
    //Shared preferences costants

    String TOKEN_CONSTANT = "token";
    String USERID_CONSTANT = "user id";
    String NAME_CONSTANT = "user name";
    String EMAIL_CONSTANT = "user email";
    String PROFILE_PIC_CONSTANT = "Profile picture uri";
    String SOME_RANDOM_STRING="some randomm string";

    //Request code constants

    int PERMISSION_REQUEST_CODE = 123;
    int REQUEST_GALLERY_CODE = 1;

    //REST constants

    String BASE_URL = "https://fierce-forest-53940.herokuapp.com/";
    String RAIL_BASE_URL = "https://api.railwayapi.com/";


    //Intent Constants

    String SINGLE_STATION_DETAILS="single station details";
    String PNR_NO="pnr number";

    //Add mob constants

    String APP_ID="ca-app-pub-3940256099942544~3347511713";


    // https://fierce-forest-53940.herokuapp.com/users/pnr-search

}
