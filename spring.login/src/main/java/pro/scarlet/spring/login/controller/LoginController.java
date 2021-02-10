package pro.scarlet.spring.login.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import pro.scarlet.spring.login.pojo.User;
import pro.scarlet.spring.login.pojo.Result;

@Controller
public class LoginController {
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // XSS fixed
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())){
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            return new Result(200);
        }

    }
}
