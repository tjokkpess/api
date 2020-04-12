package org.tjokkpess.model;

public enum PlayerPosition {
    GOALKEEPER,DEFENDER,MIDFIELDER,STRIKER,UNKNOWN;

    public static PlayerPosition mapFromStatsFC(String position) {
        if("GK".equals(position)){
            return GOALKEEPER;
        }
        if("MF".equals(position)){
            return MIDFIELDER;
        }
        if("DF".equals(position)){
            return DEFENDER;
        }
        if("FW".equals(position)){
            return STRIKER;
        }
        return UNKNOWN;

    }
}
