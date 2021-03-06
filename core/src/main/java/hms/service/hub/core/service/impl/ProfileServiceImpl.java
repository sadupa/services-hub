package hms.service.hub.core.service.impl;

import hms.service.hub.core.service.ProfileService;
import hms.service.hub.orm.dao.ProfileDao;
import hms.service.hub.orm.model.Profile;
import hms.service.hub.orm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by udara on 7/26/16.
 */

@Service("profileService")
@Transactional
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    ProfileDao profileDao;

    @Override
    public Profile getProfileById(long id) {
        return profileDao.findProfileById(id);
    }

    @Override
    public Profile getProfileByUser(User user) {
        return profileDao.findProfileByUser(user);
    }

    public Long createProfile(Profile profile) {
        return profileDao.save(profile);
    }
}
