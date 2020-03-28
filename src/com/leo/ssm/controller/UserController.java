package com.leo.ssm.controller;

import com.leo.ssm.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("/test")
    public String testUser(){
        return "user";
    }

    /**
     * 使用ModelAndView并将数据返回JSP
     * @return
     */
//    @RequestMapping("demo")
//    public ModelAndView getUser(){
//        ModelAndView model = new ModelAndView();
//        model.setViewName("user");
//        User user = new User();
//        user.setAge(28);
//        user.setName("leo");
//        model.addObject("user",user);
//        return model;
//    }

    /**
     * 重定向
     * @return
     */
    @RequestMapping("getUser")
    public String getUser(){
//        User user = new User();
//        user.setAge(28);
//        user.setName("leo");
//        modelMap.addAttribute("user",user);
//        return "user";
        return "redirect:haha";
    }

    /**
     * 页面传递参数给后台
     */
    @RequestMapping("/myUser/{age}/{name}")
    public String see(ModelMap modelMap,@PathVariable int age, @PathVariable String name){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        modelMap.addAttribute("user",user);
        return "user";
    }

    /**
     * Get请求，参数封装到User中，传递给后台
     * @param modelMap
     * @param user
     * @return
     */
    @RequestMapping("/userDemo/{age}/{name}")
    public String see(ModelMap modelMap,User user){
        modelMap.addAttribute("user",user);
        return "user";
    }

    @RequestMapping("/haha")
    public String redirect(){
        return "demo";
    }

    @RequestMapping("/hehe")
    public String heheda(ModelMap modelMap, HttpServletRequest request){
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        User user = new User();
        user.setAge(Integer.parseInt(age));
        user.setName(name);
        modelMap.addAttribute("user",user);
        return "user";
    }

//    @RequestMapping("/demo")
//    public String testDemo(){
//        return "hahah";
//    }
}
