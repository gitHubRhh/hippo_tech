package com.hippo.controller;

import com.hippo.entity.User;
import com.hippo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNullApi;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: HAOHAORUI
 * @Date: Create in 3:56 PM 2020/12/15
 * @Email: rhh0809@163.com
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {


    private static Logger logger = LoggerFactory.getLogger(UserController.class);



    private UserService userService;


    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @param httpSession
     * @param httpServletResponse
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @CrossOrigin
    public Map<String,Object> login(@RequestParam String userName, @RequestParam String passWord,
                                    HttpSession httpSession, HttpServletResponse httpServletResponse){

        Map<String,Object> map = new HashMap<String,Object>();

        User user = userService.selectUserFromName(userName);

        if (user ==null){
            logger.info("--------------------"+userName+"用户不存在");
            map.put("msg","此用户不存在");
            return map;
        }
        if(!passWord.equals(user.getPassWord())){
            logger.info("----------------------密码输入错误");
            map.put("msg","密码输入错误，请重新输入");
            return map;
        }
        httpSession.setAttribute("loginUser",user);

        map.put("msg","登录成功");

        return map;

    }



    @RequestMapping(value = "register",method = RequestMethod.POST)
    @CrossOrigin
    public Map<String,Object> register(@RequestParam String userName,@RequestParam String passWord){

        Map<String,Object> map = new HashMap<String,Object>();

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)){
            logger.info("--------------------用户名和密码不能为空");
            map.put("msg","用户名和密码不能为空");
            return map;
        }

        User user = userService.selectUserFromName(userName);

        if(user!=null){
            logger.info("--------------------"+userName+"此用户已存在");
            map.put("msg","该用户已存在");
            return map;
        }

        User insUser = new User();

        insUser.setUserName(userName);

        insUser.setPassWord(passWord);

        int count = userService.register(insUser);

        if (count != 1){
            logger.info("-------------------注册失败");
            map.put("msg","注册失败");
            return map;
        }


        map.put("msg","用户注册成功");
        return map;

    }

}
