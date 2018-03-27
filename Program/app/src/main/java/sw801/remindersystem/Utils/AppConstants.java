package sw801.remindersystem.Utils;

public final class AppConstants {

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "sw801.db"; //FIX THIS

    public static final long NULL_INDEX = -1L;

    public static final String PREF_NAME = "mindorks_pref"; //FIX THIS

    public static final String SEED_DATABASE_OPTIONS = "seed/options.json"; //FIX THIS

    public static final String SEED_DATABASE_QUESTIONS = "seed/questions.json"; //FIX THIS

    public static final String STATUS_CODE_FAILED = "failed";

    public static final String STATUS_CODE_SUCCESS = "success";

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}