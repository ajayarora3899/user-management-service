package com.spice.communication.usermanagementservice.service.impl;

import com.spice.communication.usermanagementservice.common.ServiceConstants.GENDER;
import com.spice.communication.usermanagementservice.dao.model.User;
import com.spice.communication.usermanagementservice.service.vo.request.UserRequestVO;
import com.spice.communication.usermanagementservice.service.vo.response.UserResponseVO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserObjectMapper {

    public User convertVoToModel(UserRequestVO userRequestVO){
        Date currDate=new Date();
        User user = new User();
        user.setUserId(userRequestVO.getUserId());
        user.setName(userRequestVO.getName());
        GENDER gender = GENDER.search(userRequestVO.getGender());
        user.setGender(gender.getDesc());
        user.setAddress(userRequestVO.getAddress());
        user.setMobNumber(userRequestVO.getMobNumber());
        user.setUsername(userRequestVO.getUsername());
        user.setPassword(userRequestVO.getPassword());
        user.setRegisteredOn(currDate);
        return user;
    }


    public UserResponseVO convertModelToVo(User user) {
        UserResponseVO userResponseVO=new UserResponseVO();
        userResponseVO.setUserId(user.getUserId());
        userResponseVO.setName(user.getName());
        userResponseVO.setMobNumber(user.getMobNumber());
        userResponseVO.setAddress(user.getAddress());
        userResponseVO.setUsername(user.getUsername());
        userResponseVO.setPassword(user.getPassword());
        GENDER gender = GENDER.search(user.getGender());
        userResponseVO.setGender(gender.getCode());
        userResponseVO.setRegisteredOn(user.getRegisteredOn());
        return userResponseVO;
    }
}
