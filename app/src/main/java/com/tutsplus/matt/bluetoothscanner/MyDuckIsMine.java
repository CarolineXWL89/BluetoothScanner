package com.tutsplus.matt.bluetoothscanner;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by per6 on 11/30/17.
 */

public class MyDuckIsMine {
    private AdapterView<?> parent;
    private View vies;
    private int position;
    private long id;

    public MyDuckIsMine(AdapterView<?> parent, View vies, int position, long id) {
        this.parent = parent;
        this.vies = vies;
        this.position = position;
        this.id = id;
    }

    public AdapterView<?> getParent() {
        return parent;
    }

    public View getVies() {
        return vies;
    }

    public int getPosition() {
        return position;
    }

    public long getId() {
        return id;
    }
}
