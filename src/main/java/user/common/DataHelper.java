package user.common;

import user.pojo.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHelper {

    public static List<Map<String, Object>> getSchedule(List<User> users) {
        List<Map<String, Object>> result = new ArrayList<>(20);

        for (User u : users
        ) {
            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("id", u.getId());
            userInfo.put("account", u.getAccount());
            userInfo.put("password", u.getPassword());
            userInfo.put("email",u.getEmail());

            result.add(userInfo);
        }
        return result;
    }
}
