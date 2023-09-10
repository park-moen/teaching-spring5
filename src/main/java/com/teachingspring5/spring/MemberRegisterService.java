package com.teachingspring5.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MemberRegisterService {
    private MemberDao memberDao;

    public MemberRegisterService() {
    }

    @Autowired
    public MemberRegisterService(@Qualifier("memberDao") MemberDao memberDao) {
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
