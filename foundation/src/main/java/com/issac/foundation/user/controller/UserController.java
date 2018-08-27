package com.issac.foundation.user.controller;

import com.issac.foundation.login.service.LoginService;
import com.issac.foundation.user.model.User;
import com.issac.foundation.user.service.RoleService;
import com.issac.foundation.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 3;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @CrossOrigin(origins = "*")
    //@RequestMapping(value = "/writeUser", method = RequestMethod.POST)
    @RequestMapping(value = "/writeUser")
    public User writeUser(@Valid User user, BindingResult bindingResult) throws BindException {

        User findUserOrSaveUser = userService.findUserByUserId(user.getUserId());

        if (findUserOrSaveUser != null) {
            bindingResult
                    .rejectValue("ID", "error.user",
                            "There is already a user registered with the ID provided");
        }

        if (bindingResult.hasErrors()) {
            System.out.println("============== bindingResult.hasErrors() ============== ");

            throw new BindException(bindingResult);

        } else {
            findUserOrSaveUser = userService.saveUser(user);
        }

        return findUserOrSaveUser;
    }

    // 사용자 리스트
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getListUser")
    @ResponseBody
    public Page<User> getListUser(@PageableDefault(
            page = DEFAULT_PAGE_NUMBER,
            size = DEFAULT_PAGE_SIZE,
            sort = "seq",
            direction = Direction.DESC
    ) Pageable pageable
            , @RequestParam(value = "search", required = false) String search) {

        ModelAndView modelAndView = new ModelAndView();

        Page<User> user = userService.listUser(pageable, search);

        modelAndView.addObject("user", user);
        modelAndView.setViewName("/user/listUser");

        return user;
    }

    // 사용자 조회
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findUser")
    @ResponseBody
    public Optional<User> findUser(@RequestParam("seq") @NotNull Long seq) {

        Optional<User> user = userService.findUser(seq);

        return user;
    }

    // 사용자 수정
    @RequestMapping(value = "/editUser")
    @ResponseBody
    public ModelAndView editUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            System.out.println("============== bindingResult.hasErrors() ============== ");
            System.out.println("toString : " + bindingResult.toString());

            modelAndView.setViewName("registration");
        } else {
            userService.editUser(user);
        }

        modelAndView.setViewName("/user/editUser");
        return modelAndView;
    }

    // 사용자 삭제 - 수정이 필요함(제약조건 때문에 DELETE가 안됨)
    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public ModelAndView deleteUser(@RequestParam("seq") @NotNull Long seq) {
        ModelAndView modelAndView = new ModelAndView();

        userService.deleteUser(seq);

        modelAndView.setViewName("/user/editUser");

        return modelAndView;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/companyUser")
    @ResponseBody
    public List<User> companyUser(@RequestParam("compSeq") @NotNull Long compSeq) {

        return userService.companyUser(compSeq);
    }


}
