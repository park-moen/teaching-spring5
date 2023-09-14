package com.teachingspring5.spring;

import java.time.LocalDateTime;
import java.util.Arrays;

public class MemberRegisterService {
    private final MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void register(RegisterRequest req) {
        Member member = memberDao.selectByEmail(req.getEmail());

        if (member != null) {
            throw new DuplicateMemberException("duplicate email " + req.getEmail());
        }

        Member newMember = new Member(
                req.getEmail(),
                req.getPassword(),
                req.getName(),
                LocalDateTime.now()
        );
        memberDao.insert(newMember);

    }
}
