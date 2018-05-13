package lv.va.sludinajumuportals.resource;

import lv.va.sludinajumuportals.dao.UserRepository;
import lv.va.sludinajumuportals.domain.User;
import lv.va.sludinajumuportals.domain.Response;
import lv.va.sludinajumuportals.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import static java.lang.Long.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/u")
    @ResponseBody
    public String testEndpoint() {
        return "Hello!";
    }

    @GetMapping(value = "/uhey")
    @ResponseBody
    public Response nextTestEndpoint() {
        return new Response("Hey Ya");
    }

    @RequestMapping("/umain")
    public String getUI(Map<String, Object> model) {
        model.put("message", "Hello User!");
        model.put("user", userService.getUser());
        return "main";
    }

    @GetMapping("/users")
    public String getUsers(Map<String, Object> model) {
        model.put("userList", userService.getUserListReverse());
        return "userui";
    }

    @RequestMapping("/users/{author}")
    public String getUsersByAuthor(Map<String, Object> model, @PathVariable(value = "author") String author) {
        model.put("usersList", userService.getUserListByAuthor(author));
        return "userui";
    }

    @GetMapping("/createuserform")
    public String userCreationForm(Model model) {
        model.addAttribute("user", new User());
        return "createform";
    }

    @GetMapping("/createuserformdb")
    public String userCreationFormdb(Model model) {
        model.addAttribute("user", new User());
        return "createformdb";
    }

    @PostMapping("/userdb")
    public String userSubmitdb(Map<String, Object> model,
                                      @ModelAttribute User user) 
    {
        userRepository.save(user);
        model.put("user", user);
        return "result";
    }

    @PostMapping("/user")
    public String userSubmit(Map<String, Object> model,
                                      @ModelAttribute User user) 
    {
        int nextUserId =
                userService.hardcodedUserList.size();
        user.setId(valueOf(nextUserId + 1));
        userService.hardcodedUserList
                .add(0, user);
        model.put("user", user);
        return "result";
    }
}