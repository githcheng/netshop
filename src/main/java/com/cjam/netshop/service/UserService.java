package com.cjam.netshop.service;

import com.cjam.netshop.entity.BizException;
import com.cjam.netshop.entity.User;
import com.cjam.netshop.mapper.UserDAO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jam on 2017/2/9.
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User findByOpenId(String openId) throws BizException {
        if (StringUtils.isBlank(openId)){
            throw new BizException("openid is blank");
        }

        User user = userDAO.findByOpenId(openId);

        if (user == null){
            throw new BizException("不存在此用户");
        }
        return user;
    }


    public List<User> getAllUser() throws BizException {

        List<User> userList = userDAO.getAllUser();

        if (CollectionUtils.isEmpty(userList)){
            throw new BizException("暂无用户");
        }
        return userList;
    }
}
