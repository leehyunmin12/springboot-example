package com.example.fisrtproject.controller;

import com.example.fisrtproject.dto.MemberForm;
import com.example.fisrtproject.entity.Member;
import com.example.fisrtproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/new")
    public String signin (){
        return "members/new";
    }

    @PostMapping("/join")
    public String createMembers(MemberForm form) {
        // System.out.println(form.toString());
        log.info(form.toString());
        //dto를 엔티티로 변환
        Member member = form.toEntity();
        // System.out.println(member.toString());
        log.info(member.toString());
        //DB
        Member saved = memberRepository.save(member);
        // System.out.println(saved.toString());
        log.info(saved.toString());

        return "members/new";
    }
}
