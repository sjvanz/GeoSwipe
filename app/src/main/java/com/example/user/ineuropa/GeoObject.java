package com.example.user.ineuropa;

public class GeoObject {

    private boolean isInEurope;
    private String mGeoName;
    private int mGeoImageName;


    public GeoObject(boolean isInEurope,int mGeoImageName, String mGeoName) {
        this.mGeoName = mGeoName;
        this.mGeoImageName = mGeoImageName;
        this.isInEurope = isInEurope;
    }

    public String getmGeoName() {
        return mGeoName;
    }

    public void setmGeoName(String mGeoName) {
        this.mGeoName = mGeoName;
    }

    public int getmGeoImageName() {
        return mGeoImageName;
    }

    public void setmGeoImageName(int mGeoImageName) {
        this.mGeoImageName = mGeoImageName;
    }

    public boolean getIsInEurope() {
        return isInEurope;
    }

    public void setIsInEurope(boolean isInEurope) {
        this.isInEurope = isInEurope;
    }

    public static final String[] PRE_DEFINED_GEO_OBJECT_NAMES = {

            "Amsterdam Dam",
            "Rotterdam Euromast",
            "Maastricht Vrijthof",
            "San Francisco Golden Gate",
            "Brussel Manneken Pis",
            "Beijing Verboden Stad",
            "Kaapstad Tafelberg",
            "Hawaii Honolulu",

    };

    public static final int[] PRE_DEFINED_GEO_OBJECT_IMAGE_IDS = {

            R.drawable.amsterdam_dam,
            R.drawable.rotterdam_euromast,
            R.drawable.maastricht_vrijthof,
            R.drawable.san_francisco_golden_gate,
            R.drawable.brussel_manneken_pis,
            R.drawable.beijing_verboden_stad,
            R.drawable.kaapstad_tafelberg,
            R.drawable.hawaii,

    };

    public static final boolean[] PRE_DEFINED_IS_IN_EUROPE = {
            true,
            true,
            true,
            false,
            true,
            false,
            false,
            false
    };
}
