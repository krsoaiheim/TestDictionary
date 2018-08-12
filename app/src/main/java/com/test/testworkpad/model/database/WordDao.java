package com.test.testworkpad.model.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "translations".
*/
public class WordDao extends AbstractDao<Word, Long> {

    public static final String TABLENAME = "translations";

    /**
     * Properties of entity Word.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property FromWord = new Property(1, String.class, "fromWord", false, "FROM_WORD");
        public final static Property ToWord = new Property(2, String.class, "toWord", false, "TO_WORD");
        public final static Property FromLang = new Property(3, int.class, "fromLang", false, "FROM_LANG");
        public final static Property ToLang = new Property(4, int.class, "toLang", false, "TO_LANG");
    }

    private DaoSession daoSession;


    public WordDao(DaoConfig config) {
        super(config);
    }
    
    public WordDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"translations\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"FROM_WORD\" TEXT," + // 1: fromWord
                "\"TO_WORD\" TEXT," + // 2: toWord
                "\"FROM_LANG\" INTEGER NOT NULL ," + // 3: fromLang
                "\"TO_LANG\" INTEGER NOT NULL );"); // 4: toLang
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"translations\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Word entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String fromWord = entity.getFromWord();
        if (fromWord != null) {
            stmt.bindString(2, fromWord);
        }
 
        String toWord = entity.getToWord();
        if (toWord != null) {
            stmt.bindString(3, toWord);
        }
        stmt.bindLong(4, entity.getFromLang());
        stmt.bindLong(5, entity.getToLang());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Word entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String fromWord = entity.getFromWord();
        if (fromWord != null) {
            stmt.bindString(2, fromWord);
        }
 
        String toWord = entity.getToWord();
        if (toWord != null) {
            stmt.bindString(3, toWord);
        }
        stmt.bindLong(4, entity.getFromLang());
        stmt.bindLong(5, entity.getToLang());
    }

    @Override
    protected final void attachEntity(Word entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Word readEntity(Cursor cursor, int offset) {
        Word entity = new Word( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // fromWord
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // toWord
            cursor.getInt(offset + 3), // fromLang
            cursor.getInt(offset + 4) // toLang
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Word entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFromWord(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setToWord(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setFromLang(cursor.getInt(offset + 3));
        entity.setToLang(cursor.getInt(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Word entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Word entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Word entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
