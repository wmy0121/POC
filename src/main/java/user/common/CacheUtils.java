package user.common;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import user.pojo.User;

import java.util.concurrent.TimeUnit;

public class CacheUtils {
    private static final ThreadLocal<String> currentToken = new ThreadLocal<>();

    private static final Cache<String, User> USER_CACHE = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .build();

    public static void cacheUser(String token,User user){
            USER_CACHE.put(token,user);
    }

    public static User getUser(String token){
         return USER_CACHE.getIfPresent(token);
    }


    public static User getCurrentUser(){
            return USER_CACHE.getIfPresent(currentToken.get());

    }

    public static  void removeUser(){
          USER_CACHE.invalidate(currentToken.get());

    }

    public static void storeCurrentToken(String token){
            currentToken.set(token);
    }

}
