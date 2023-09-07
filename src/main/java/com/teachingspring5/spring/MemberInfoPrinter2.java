package com.teachingspring5.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter2 {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter printer;

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);

        if (member == null) {
            System.out.println("데이터 없음\n");
            return;
        }

        printer.print(member);
        System.out.println();
    }
}
