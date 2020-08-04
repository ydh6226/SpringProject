package com.ydh.SpringProject;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {

    @Autowired
    private MemberDao memberDao;

    public void changePassword(String email, String oldPwd, String newPwd){
        Member member=memberDao.selectByEmail(email);

        if(member==null)
            throw new MemberNotFoundException();

        member.changePassword(oldPwd,newPwd);

        memberDao.update(member);
    }

    /* @Autowired써서 의존주입했기 때문에 세터 따로 정의 안해도 됨.
    public void setMemberDao(MemberDao memberDao){
        this.memberDao=memberDao;
    }
     */
}
