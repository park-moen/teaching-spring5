package com.teachingspring5.main;

import com.teachingspring5.config.AppContext;
import com.teachingspring5.spring.ChangePasswordService;
import com.teachingspring5.spring.MemberNotFoundException;
import com.teachingspring5.spring.WrongIdPasswordException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForCPS {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
        ChangePasswordService changePasswordService = ctx.getBean("changePasswordService", ChangePasswordService.class);

        try {
            changePasswordService.changePassword("jae@naver.com", "1234", "1111");
            System.out.println("암호를 변경혔습니다.");
        } catch (MemberNotFoundException e) {
            System.out.println("회원 데이터가 존재하지 않습니다.");
        } catch (WrongIdPasswordException e) {
            System.out.println("암호가 올바르지 않습니다.");

        }


        ctx.close();
    }
}

