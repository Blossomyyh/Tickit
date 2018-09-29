package com.example.ricardo.tickit2.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.ricardo.tickit2.data.entity.GDUser;

import com.example.ricardo.tickit2.greendao.gen.GDUserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig gDUserDaoConfig;

    private final GDUserDao gDUserDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        gDUserDaoConfig = daoConfigMap.get(GDUserDao.class).clone();
        gDUserDaoConfig.initIdentityScope(type);

        gDUserDao = new GDUserDao(gDUserDaoConfig, this);

        registerDao(GDUser.class, gDUserDao);
    }
    
    public void clear() {
        gDUserDaoConfig.clearIdentityScope();
    }

    public GDUserDao getGDUserDao() {
        return gDUserDao;
    }

}