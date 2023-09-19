package user.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import user.common.*;
import user.dao.UserDao;


import user.pojo.LoginRequest;
import user.pojo.User;
import user.services.UserService;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
@Validated
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @PutMapping("/register")
    public ResultJSONObject register(@RequestBody @Validated User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResultJSONObject createAuthenticationToken(@RequestBody LoginRequest loginRequest) {
        ResultJSONObject result = ResultJSONObject.success();
        String account = loginRequest.getAccount();
        User user = userDao.findByAccount(account);
        Map<String, Object> data = new HashMap<>(1);
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            String token = new Token().generateToken(user);
            int type = new Token().extractType(token);
            data.put("type", type);
            data.put("Authorization", token);
            result = new ResultJSONObject(RespCode.SUCCESS, null, data);
        } else {
            result = new ResultJSONObject(RespCode.FAIL);
        }
        return result;
    }

    @GetMapping("/list")
    public ResultJSONObject getSchedule(@RequestHeader("authorizationToken") String authorizationToken) {
        List<User> scheduleList = new ArrayList<>();
        ResultJSONObject result = ResultJSONObject.success();
        int type = new Token().extractType(authorizationToken);
        int userId = new Token().extractUserId(authorizationToken);
        if (type == 1) {
            scheduleList = userDao.findAll();
        } else {
            User user = userDao.findById(userId);
            scheduleList.add(user);
        }
        result.setData(DataHelper.getSchedule(scheduleList));
        return result;
    }

    @PutMapping("/update")
    public ResultJSONObject updateUser(@RequestBody User user) {
        ResultJSONObject result = ResultJSONObject.success();
        try {
            userDao.save(user);
            result = new ResultJSONObject(RespCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常堆栈信息
            result = new ResultJSONObject(RespCode.FAIL);
        }
        return result;
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultJSONObject deleteUserById(@PathVariable int id) {
        ResultJSONObject result = ResultJSONObject.success();
        try {
            userDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常堆栈信息
            result = new ResultJSONObject(RespCode.FAIL);
        }
        return result;
    }

    @PutMapping("/add")
    public ResultJSONObject addUser(@RequestBody User user) {
     return  userService.register(user);
    }

}

