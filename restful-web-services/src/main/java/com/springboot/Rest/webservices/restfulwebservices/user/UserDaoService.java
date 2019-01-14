package com.springboot.Rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Component
public class UserDaoService {
    private static int userCount = 4;
    private static List<User> user = new ArrayList< >();
    static {
        user.add(new User(1,"Abuye", "Male",new Date()));
        user.add(new User(2,"Bisat", "Male",new Date()));
        user.add(new User(3,"Haile", "Male",new Date()));
        user.add(new User(4,"Senay", "Male",new Date()));
         }
         public List<User> findAll()
         {
             return user;
         }
         public User save(User users)
         {
             if(users.getId() == null)
             {
                 users.setId(++ userCount);
             }
             user.add(users);
             return users;
         }
         public User findOne(int id)
         {
             for(User users : user)
             {
                 if(users.getId() == id)
                 {
                     return users;
                 }

             }
             return null;
         }
    public User DeleteUserById(int id)
    {

        Iterator<User> iterator = user.iterator();
        while (iterator.hasNext())

        {
            User user = iterator.next();
            if(user.getId() == id)
            {
                iterator.remove();
                return user;
            }

        }
        return null;
    }


}