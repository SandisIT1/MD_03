
package lv.va.sludinajumuportals.service;

import lv.va.sludinajumuportals.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService 
{
    String name = "Sandis";
    public List<User> hardcodedUserList;
    public List<User> reverseUserList;

    public UserService() 
    {
        hardcodedUserList = hardcodedUserInititialization();
        reverseUserList = hardcodedUserList;
        Collections.reverse(reverseUserList);
    }

    public User getUser() 
    {
        User user = new User(1L, "Janis", "Berzins", 'V');
        return user;
    }

    public List<User> getUserListByAuthor(String author) 
    {
        List<User> filteredByName = new ArrayList<>();
        for (User user : hardcodedUserList) 
        {
            if(user.getName().matches(author) || user.getSurname().matches(author)) 
            {
                filteredByName.add(user);
            }
        }
        return filteredByName;
    }

    public List<User> getUserListReverse()
    {
        return reverseUserList;
    }

    public ArrayList<User> getUserList()
    {
        ArrayList<User> users = new ArrayList<>();
        User user = new User(1L, "Janis", "Berzins", 'V');
        users.add(user);
        return users;
    }

    private List<User> hardcodedUserInititialization() 
    {
        List<User> users = new ArrayList<>();
        for(int i = 1; i< name.length(); i++){
            User user = new User(Long.valueOf(i), getAuthorName(i), getAuthorName(i), 'V');
            users.add(user);
        }
        return users;
    }

    private String getAuthorName(int i) 
    {
        if(i % 2 == 0 ) 
        {
            return "Jānis";
        }
        return "Pēteris";
    }
}