package org.amaap.ttp.scrabble.v1.domain;


public class ScarbbleManager {
    private static ScarbbleManager scarbbleManager;

    private ScarbbleManager() {

    }

    public static synchronized ScarbbleManager getInstance() {
        if (scarbbleManager == null)
            scarbbleManager = new ScarbbleManager();
        return scarbbleManager;
    }


}
