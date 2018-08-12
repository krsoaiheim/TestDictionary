package com.test.testworkpad.model.database;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity(active = true, nameInDb = "translations")
public class Word {
  @Id
  private Long id;
  private String fromWord;
  private String toWord;
  private int fromLang;
  private int toLang;
  /**
   * Used to resolve relations
   */
  @Generated(hash = 2040040024)
  private transient DaoSession daoSession;
  /**
   * Used for active entity operations.
   */
  @Generated(hash = 768131649)
  private transient WordDao myDao;


  @Generated(hash = 179566370)
  public Word(Long id, String fromWord, String toWord, int fromLang, int toLang) {
    this.id = id;
    this.fromWord = fromWord;
    this.toWord = toWord;
    this.fromLang = fromLang;
    this.toLang = toLang;
  }


  @Generated(hash = 3342184)
  public Word() {
  }


  public String getFromWord() {
    return fromWord;
  }


  public void setFromWord(String fromWord) {
    this.fromWord = fromWord;
  }


  public String getToWord() {
    return toWord;
  }


  public void setToWord(String toWord) {
    this.toWord = toWord;
  }


  public int getFromLang() {
    return fromLang;
  }


  public void setFromLang(int fromLang) {
    this.fromLang = fromLang;
  }


  public int getToLang() {
    return toLang;
  }


  public void setToLang(int toLang) {
    this.toLang = toLang;
  }


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  /**
   * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
   * Entity must attached to an entity context.
   */
  @Generated(hash = 128553479)
  public void delete() {
    if (myDao == null) {
      throw new DaoException("Entity is detached from DAO context");
    }
    myDao.delete(this);
  }


  /**
   * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
   * Entity must attached to an entity context.
   */
  @Generated(hash = 1942392019)
  public void refresh() {
    if (myDao == null) {
      throw new DaoException("Entity is detached from DAO context");
    }
    myDao.refresh(this);
  }


  /**
   * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
   * Entity must attached to an entity context.
   */
  @Generated(hash = 713229351)
  public void update() {
    if (myDao == null) {
      throw new DaoException("Entity is detached from DAO context");
    }
    myDao.update(this);
  }


  /**
   * called by internal mechanisms, do not call yourself.
   */
  @Generated(hash = 2107838493)
  public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getWordDao() : null;
  }
}
