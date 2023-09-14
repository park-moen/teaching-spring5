package com.teachingspring5.main;

import com.teachingspring5.config.AppContext;
import com.teachingspring5.spring.Member;
import com.teachingspring5.spring.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainForMemberDao {
    private static MemberDao memberDao;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
        memberDao = ctx.getBean(MemberDao.class);

        selectAll();
        updateMember();
        insertMember();

        ctx.close();
    }

    private static void selectAll() {
        System.out.println("----- selectAll");

        int total = memberDao.count();
        System.out.println("전체 데이터: " + total);

        List<Member> members = memberDao.selectAll();

        for (Member member : members) {
            System.out.println(member.getId() + ":" + member.getEmail() + ":" + member.getName());
        }
    }

    private static void updateMember() {
        System.out.println("----- updateMember");

        Member member = memberDao.selectByEmail("moen@naver.com");
        String oldPassword = member.getPassword();
        String newPassword = Double.toHexString(Math.random());

        member.changePassword(oldPassword, newPassword);
        memberDao.update(member);

        System.out.println("암호 변경: " + oldPassword + " > " + newPassword);
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddHHmmss");

    private static void insertMember() {
        System.out.println("----- insertMember");

        String prefix = formatter.format(LocalDateTime.now());
        Member member = new Member(
                prefix + "@test.com",
                prefix,
                prefix,
                LocalDateTime.now()
        );

        memberDao.insert(member);
        System.out.println(member.getId() + " 데이터 추가");
    }
}
