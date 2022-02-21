package com.spice.communication.usermanagementservice.service;

import com.spice.communication.usermanagementservice.service.exception.SpiceBaseException;
import com.spice.communication.usermanagementservice.service.vo.request.UserRequestVO;
import com.spice.communication.usermanagementservice.service.vo.response.DropdownVO;
import com.spice.communication.usermanagementservice.service.vo.response.UserResponseVO;

import java.util.List;

public interface UserService {
    List<DropdownVO> getGenderDropdown();


    UserResponseVO createUser(UserRequestVO userRequestVO);

    UserResponseVO validateUser(String uname, String pass) throws SpiceBaseException;
}
