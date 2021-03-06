package com.test.testworkpad.model.database;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.test.testworkpad.model.database.Word;

import com.test.testworkpad.model.database.WordDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig wordDaoConfig;

    private final WordDao wordDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        wordDaoConfig = daoConfigMap.get(WordDao.class).clone();
        wordDaoConfig.initIdentityScope(type);

        wordDao = new WordDao(wordDaoConfig, this);

        registerDao(Word.class, wordDao);
    }
    
    public void clear() {
        wordDaoConfig.clearIdentityScope();
    }

    public WordDao getWordDao() {
        return wordDao;
    }

}
