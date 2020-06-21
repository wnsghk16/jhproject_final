package com.jhproject.web.member;


import com.jhproject.web.proxy.Box;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class MemberController {
    @Autowired MemberRepository memberRepository;
    @Autowired Box<Object> box;

    @GetMapping("/selectAll")
    public List<Member> selectAll(){
        return memberRepository.findAll();
    }

    @PostMapping("/signup")
    public boolean signUpUser(@RequestBody Member member) {
        if(idcheck(member.getId())){
            return true;
        }else{
            memberRepository.saveAndFlush(member);
            System.out.println(member);
            return false;
        }
    }

    @GetMapping("/{id}")
    public boolean idcheck(@PathVariable String id){
        return (memberRepository.findById(id) != null)? true:false;
    }

    @PostMapping("/signin")
    public HashMap<String, Object> singin(@RequestBody Member loginUser){
        box.clear();
        String result = "";
        boolean check = false;
        Member member = memberRepository.findById(loginUser.getId());
        if(member == null){
            result = "로그인 실패";
        }else if(member.getId().equals(loginUser.getId())){
            if (member.getPasswd().equals(loginUser.getPasswd())){
                result = "로그인 성공";
                check = true;
            }else {
                result = "비밀번호를 확인해주세요";
            }
        }
        box.put("result",result);
        box.put("check",check);
        box.put("member",member);
        System.out.println(box.get("result"));
        System.out.println(box.get("check"));
        System.out.println(box.get("member"));
        return box.get();
    }

}
