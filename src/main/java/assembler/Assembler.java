package assembler;

import com.ydh.SpringProject.ChangePasswordService;
import com.ydh.SpringProject.MemberDao;
import com.ydh.SpringProject.MemberRegisterService;

public class Assembler {
    private MemberDao memberDao;
    private MemberRegisterService regSvc;
    private ChangePasswordService pwdSvc;

    public Assembler(){
        memberDao=new MemberDao();
        regSvc=new MemberRegisterService(memberDao);
        pwdSvc=new ChangePasswordService();
        pwdSvc.setMemberDao(memberDao);
    }

    public MemberDao getMemberDao(){
        return memberDao;
    }

    public MemberRegisterService getMemberRegisterService(){
        return regSvc;
    }

    public ChangePasswordService getChangePasswordService(){
        return pwdSvc;
    }
}
