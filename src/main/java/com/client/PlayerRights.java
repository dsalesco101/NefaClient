package com.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

public enum PlayerRights {

    PLAYER(0, "000000"),
    HELPER(11, "004080"),
    MODERATOR(1, "#0000ff", HELPER),
    ADMINISTRATOR(2, "F5FF0F", MODERATOR),
    OWNER(3, "F5FF0F", ADMINISTRATOR),
    UNKNOWN(4, "F5FF0F"),
    REGULAR_DONATOR(5, "B60818"),
    SUPER_DONOR(6, "063DCF", REGULAR_DONATOR),
    EXTREME_DONOR(7, "118120", SUPER_DONOR),

    ULTRA_DONATOR(8, "9E00DE", EXTREME_DONOR),
    LEGENDARY_DONATOR(9, "9E6405", ULTRA_DONATOR),
    DIAMOND_CLUB(17, "9E6405", LEGENDARY_DONATOR),
    ONYX_CLUB(18, "9E6405", DIAMOND_CLUB),
    PLATINUM(19, "9E6405", ONYX_CLUB),
    DIVINE(20, "9E6405", PLATINUM),

    //RESPECTED_MEMBER(10, "272727"),
    HITBOX(12, "437100"),
    IRONMAN(13, "3A3A3A"),
    ULTIMATE_IRONMAN(14, "717070"),
    YOUTUBER(15, "FE0018"),
    GAME_DEVELOPER(16, "544FBB"),
    OSRS(23, "437100"),
    MEMBERSHIP(21, "437100"),
    TRIAL_DONATOR(24, "B60818"),//i use this one
    HC_IRONMAN(10, "60201f");

    public static final EnumSet[] DISPLAY_GROUPS = {
            EnumSet.of(HELPER, MODERATOR, ADMINISTRATOR, OWNER, UNKNOWN, REGULAR_DONATOR, SUPER_DONOR, EXTREME_DONOR,
                    ULTRA_DONATOR, LEGENDARY_DONATOR, DIAMOND_CLUB, ONYX_CLUB, PLATINUM, DIVINE),
            EnumSet.of(HITBOX, IRONMAN, ULTIMATE_IRONMAN, YOUTUBER, GAME_DEVELOPER, OSRS, MEMBERSHIP, TRIAL_DONATOR, HC_IRONMAN)
    };

    public static PlayerRights forRightsValue(int rightsValue) {
        Optional<PlayerRights> rights = Arrays.stream(PlayerRights.values()).filter(right -> right.getRightsId() == rightsValue).findFirst();
        if (rights.isPresent()) {
            return rights.get();
        } else {
            System.err.println("No rights for value " + rightsValue);
            return PlayerRights.PLAYER;
        }
    }

    public static List<PlayerRights> getDisplayedRights(PlayerRights[] set) {
        List<PlayerRights> rights = new ArrayList<>();

        for (PlayerRights right : set) {
            if (DISPLAY_GROUPS[0].contains(right)) {
                rights.add(right);
                break; // Only displaying one crown from this group!
            }
        }

        for (PlayerRights right : set) {
            if (DISPLAY_GROUPS[1].contains(right)) {
                if (rights.size() < 2) {
                    rights.add(right);
                }
            }
        }

        return rights;
    }

    public static PlayerRights[] ordinalsToArray(int[] ordinals) {
        PlayerRights[] rights = new PlayerRights[ordinals.length];
        for (int index = 0; index < ordinals.length; index++) {
            rights[index] = PlayerRights.values()[ordinals[index]];
        }
        return rights;
    }

    public static Pair<Integer, PlayerRights[]> readRightsFromPacket(Stream inStream) {
        int rightsAmount = inStream.readUnsignedByte();
        int[] ordinals = new int[rightsAmount];
        for (int right = 0; right < rightsAmount; right++) {
            ordinals[right] = inStream.readUnsignedByte();
        }
        return Pair.of(rightsAmount, PlayerRights.ordinalsToArray(ordinals));
    }

    public static boolean hasRightsOtherThan(PlayerRights[] rights, PlayerRights playerRight) {
        return Arrays.stream(rights).anyMatch(right -> right != playerRight);
    }

    public static boolean hasRights(PlayerRights[] rights, PlayerRights playerRights) {
        return Arrays.stream(rights).anyMatch(right -> right == playerRights);
    }

    public static boolean hasRightsLevel(PlayerRights[] rights, int rightsId) {
        return Arrays.stream(rights).anyMatch(right -> right.getRightsId() >= rightsId);
    }

    public static boolean hasRightsBetween(PlayerRights[] rights, int low, int high) {
        return Arrays.stream(rights).anyMatch(right -> right.getRightsId() > low && right.getRightsId() < high);
    }

    public static String buildCrownString(List<PlayerRights> rights) {
        return buildCrownString(rights.toArray(new PlayerRights[0]));
    }

    public static String buildCrownString(PlayerRights[] rights) {
        StringBuilder builder = new StringBuilder();
        for (PlayerRights right : rights) {
            if (right.hasCrown()) {
                builder.append("@cr" + right.crownId() + "@");
            }
        }
        return builder.toString();
    }

    /**
     * The level of rights that define this
     */
    private final int rightsId;

    /**
     * The rights inherited by this right
     */
    private final List<PlayerRights> inherited;

    /**
     * The color associated with the right
     */
    private final String color;

    /**
     * Creates a new right with a value to differentiate it between the others
     *
     * @param right the right required
     * @param color a color thats used to represent the players name when displayed
     * @param inherited the right or rights inherited with this level of right
     */
    PlayerRights(int right, String color, PlayerRights... inherited) {
        this.rightsId = right;
        this.inherited = Arrays.asList(inherited);
        this.color = color;
    }

    public boolean isStaffPosition() {
        return this == HELPER || this == ADMINISTRATOR || this == MODERATOR || this == OWNER || this == GAME_DEVELOPER;
    }

    public int spriteId() {
        return rightsId - 1;
    }

    public int crownId() {
        return rightsId;
    }

    public boolean hasCrown() {
        return this != PlayerRights.PLAYER;
    }

    public int getRightsId() {
        return rightsId;
    }
}
