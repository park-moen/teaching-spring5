package com.teachingspring5.assembler;

import com.teachingspring5.spring.ChangePasswordService;
import com.teachingspring5.spring.MemberDao;
import com.teachingspring5.spring.MemberRegisterService;

public class Assembler {
    private final MemberDao memberDao;
    private final MemberRegisterService memberRegisterService;
    private final ChangePasswordService changePasswordService;

    public Assembler() {
        memberDao = new MemberDao();
        memberRegisterService = new MemberRegisterService(memberDao);
        changePasswordService = new ChangePasswordService();
        changePasswordService.setMemberDao(memberDao);
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public MemberRegisterService getMemberRegisterService() {
        return memberRegisterService;
    }

    public ChangePasswordService getChangePasswordService() {
        return changePasswordService;
    }
}
