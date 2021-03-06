package com.client;

public class Configuration {

	public static boolean developerMode = false;
	public static boolean newFonts = false;
	public static String clientTitle = "";

	/**
	 * Attack option priorities 0 -> Depends on combat level 1 -> Always right-click
	 * 2 -> Left-click where available 3 -> Hidden
	 */
	public static int playerAttackOptionPriority = 0;
	public static int npcAttackOptionPriority = 2;

	public static boolean debug = true;
	public static final boolean DUMP_SPRITES = false;
	public static final boolean PRINT_EMPTY_INTERFACE_SECTIONS = false;

	public static int xpSize = 0;
	public static int xpSpeed = 0;
	public static int xpDuration = 0;
	public static int xpColour = 0;
	public static int xpGroup = 0;

	public static boolean playerNames = false;
	public static long fogDelay = 500;
	public static final String CLIENT_TITLE = "NefariousPkz";

	public static final int CLIENT_VERSION = 143;
	public static final int PORT = 43594;
	public static final int TEST_PORT = 43595;

	public static Boolean DUMP_DATA = false;
	public static int dumpID = 149;
	public static Boolean DUMP_OTHER = false;

	public static String ERROR_LOG_FILE = "error_log.txt";

	/**
	 * Used to repack indexes Index 1 = Models Index 2 = Animations Index 3 =
	 * Sounds/Music Index 4 = Maps You can only do up to 300 files at a time
	 */

	public static final String CACHE_NAME = "NexCache";

	public static boolean repackIndexOne = false, repackIndexTwo = false, repackIndexThree = false,
			repackIndexFour = false;

	public static final String CACHE_LINK = "https://www.dropbox.com/s/cjntszrb0tg234j/NexCache.zip?dl=1";
	
	public static final String VERSION_URL;

	static {
		VERSION_URL = "https://www.dropbox.com/s/smcuop5ch4qzykm/version.txt?dl=1";
	}

	/**
	 * Seasonal Events
	 */
	public static boolean HALLOWEEN = false;
	public static boolean CHRISTMAS = false;
	public static boolean CHRISTMAS_EVENT = false;
	public static boolean EASTER = false;

	public static boolean osbuddyGameframe = false;

	public static boolean oldGameframe = false;
	public static int gameWorld = 1;

	public static int xpPosition;
	public static boolean escapeCloseInterface = false;
	public static boolean alwaysLeftClickAttack;
	public static boolean hideCombatOverlay;

}
