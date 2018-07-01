package diary.dan.mydiary.data;


import android.provider.BaseColumns;

public final class DiaryContract {

    //This class holds constants for tables in the database
    private DiaryContract(){}

    public static final class DiaryEntry implements BaseColumns{
        /** Name of database table for Entries to the diary */
        public final static String TABLE_NAME = "memos";

        /**
         * Unique ID number for the entry in the diary.
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

       /**
       * Title of Entry.
        *
        *
        *Type = TEXT
        * */
       public final static String COLUMN_MEMO_TITLE ="title";

        /**
         * Content of memo
         *
         * Type = TEXT
         */
        public final static String COLUMN_MEMO_CONTENT = "content";

        /**
         * date created
         *
         * Type = INTEGER stores seconds since Unix epoch
         */
        public final static String COLUMN_MEMO_DATE = "date";

        /**
         * attached image
         *
         * Type = TEXT stores uri to locate image on disk
         */
        public final static String COLUMN_MEMO_IMAGE = "image";
        /**
         * location
         *
         * Type = TEXT
         */
        public final static String COLUMN_MEMO_LOCATION = "location";
    }
}
