package kr.co.sohyeon.controller;

import kr.co.sohyeon.dto.User1DTO;
import kr.co.sohyeon.service.User1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user1")
public class User1Controller {

    private final User1Service service;

    @GetMapping("/list")
    public String list(Model model) {
        List<User1DTO> user1DTOList = service.findAll();
        model.addAttribute("user1List", user1DTOList);  // 이름 명시
        return "/user1/list";
    }

    @GetMapping("/register")
    public String register() {
        return "/user1/register";
    }

    @PostMapping("/register")
    public String register(User1DTO user1DTO) {
        service.save(user1DTO);
        return "redirect:/user1/list"; // 등록 후 목록으로 리디렉션
    }

    @GetMapping("/modify")
    public String modify(@RequestParam String uid, Model model) {
        User1DTO user1DTO = service.findById(uid);
        model.addAttribute(user1DTO);
        return "/user1/modify";
    }

    @PostMapping("/modify")
    public String modify(User1DTO user1DTO) {
        service.modify(user1DTO);
        return "redirect:/user1/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String uid) {
        service.delete(uid);
        return "redirect:/user1/list";
    }
}
