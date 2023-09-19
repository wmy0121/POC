package user.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user.common.RespCode;
import user.common.ResultJSONObject;
import user.dao.UserDao;
import user.exception.UserManagementException;
import user.pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    EntityManager entityManager;

    public ResultJSONObject register(User user) {
        ResultJSONObject result = null;
        try {
            TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.account = :account", User.class);
            query.setParameter("account", user.getAccount());
            User existingUser = query.getSingleResult();
            // 如果找到用户，返回失败结果
            result = new ResultJSONObject(RespCode.FAIL);
        } catch (NoResultException e) {
            // 如果找不到用户，保存新用户并返回成功结果
            userDao.save(user);
            result = new ResultJSONObject(RespCode.SUCCESS);
        } catch (Exception e) {
            // 处理其他异常
            e.printStackTrace();
            result = new ResultJSONObject(RespCode.ERROR);
        }

        return result;
    }

}
