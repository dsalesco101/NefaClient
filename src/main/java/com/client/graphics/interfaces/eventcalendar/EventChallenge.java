package com.client.graphics.interfaces.eventcalendar;

import com.client.RSFont;
import com.client.TextClass;

public enum EventChallenge {

    WIN_AN_OUTLAST_TOURNAMENT,
    OBTAIN_X_WILDY_EVENT_KEYS(5),
    GAIN_X_PEST_CONTROL_POINTS(400),
    COMPLETE_X_HARD_SLAYER_ASSIGNMENTS(15),
    CUT_DOWN_X_MAGIC_LOGS(1500),
    KILL_X_BARROWS_BROTHERS(200),
    GET_X_KILLS_IN_WILDY(5),
    COMPLETE_X_RAIDS(10),
    WIELD_A_DRAGON_DEFENDER,
    BURY_X_DRAGON_BONES(500),
    HAVE_126_COMBAT,
    COMPLETE_A_63_WAVE_FIRE_CAPE,
    KILL_X_REVS_IN_WILDY(300),
    GAIN_X_EXCHANGE_POINTS(15000),
    KILL_X_WILDY_BOSSES(30),
    COMPLETE_X_HARD_ACHIEVEMENTS(3),
    CATCH_X_BLACK_CHINCHOMPAS(150),
    GAIN_X_PVM_POINTS(1000),
    PARTICIPATE_IN_X_OUTLAST_TOURNIES(4),
    WIELD_FULL_ELITE_VOID,
    KILL_ZULRAH_X_TIMES(50),
    KILL_HUNLLEF_X_TIMES(3),
    KILL_X_GODWARS_BOSSES_OF_ANY_TYPE(30),
    HAVE_2000_TOTAL_LEVEL
    ;

    private final int ticks;

    EventChallenge() {
        this(1);
    }

    EventChallenge(int ticks) {
        this.ticks = ticks;
    }

    public String getWrappedString(RSFont font, String colour) {
        String formatted = getFormattedString();
        String[] split = formatted.split(" ");
        StringBuilder builder = new StringBuilder();
        builder.append(colour);
        int width = 0;
        for (int index = 0; index < split.length; index++) {
            boolean newLine = false;
            if (width + font.getTextWidth(split[index]) >= 70) {
                builder.append("\\n");
                builder.append(colour);
                newLine = true;
                width = 0;
            }
            builder.append((index != 0 && !newLine ? " " : "") + split[index]);
            width += font.getTextWidth(split[index]);
        }
        return builder.toString();
    }

    public String getFormattedString() {
        return TextClass.fixName(toString()
                .toLowerCase()
                .replace("_x_", "_" + ticks + "_")
                .replaceAll("_", " "));
    }


}
