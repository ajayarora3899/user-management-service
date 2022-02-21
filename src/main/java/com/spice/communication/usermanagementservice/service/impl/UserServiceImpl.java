package com.spice.communication.usermanagementservice.service.impl;

import com.spice.communication.usermanagementservice.common.ErrorCodes;
import com.spice.communication.usermanagementservice.common.ServiceConstants.GENDER;
import com.spice.communication.usermanagementservice.dao.UserDao;
import com.spice.communication.usermanagementservice.dao.model.User;
import com.spice.communication.usermanagementservice.service.UserService;
import com.spice.communication.usermanagementservice.service.exception.SpiceBaseException;
import com.spice.communication.usermanagementservice.service.vo.request.UserRequestVO;
import com.spice.communication.usermanagementservice.service.vo.response.DropdownVO;
import com.spice.communication.usermanagementservice.service.vo.response.UserResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Throwable.class)
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserObjectMapper userObjectMapper;

    @Override
    public List<DropdownVO> getGenderDropdown() {
        List<DropdownVO> dropdownVOList = new ArrayList<>();
        for (GENDER gender : GENDER.values()) {
            dropdownVOList.add(new DropdownVO(gender.getCode(), gender.getDesc()));
        }
        return dropdownVOList;
    }

    @Override
    public UserResponseVO createUser(UserRequestVO userRequestVO) {
        User user = userObjectMapper.convertVoToModel(userRequestVO);
        user = userDao.save(user);
        UserResponseVO userResponseVO = userObjectMapper.convertModelToVo(user);
        return userResponseVO;
    }

    @Override
    public UserResponseVO validateUser(String uname, String pass) throws SpiceBaseException {
        User user = userDao.findByUnameAndPass(uname, pass);
        if (user == null) {
            throw new SpiceBaseException(ErrorCodes.USER_NOT_REGISTERED.getMessage(), ErrorCodes.USER_NOT_REGISTERED.getErrorCode());
        }
        UserResponseVO userResponseVO = userObjectMapper.convertModelToVo(user);
        return userResponseVO;
    }
}
