package org.tjokkpess.client.statsfc;

import org.tjokkpess.model.PlayerPosition;

import static org.tjokkpess.model.PlayerPosition.*;

public class StatsFCMapper {
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
