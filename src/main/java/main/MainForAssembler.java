package main;

import assembler.Assembler;
import com.ydh.SpringProject.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForAssembler {
    public static void main(String[] args) throws IOException{
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("명령어를 입력하시오 : ");
            String command=reader.readLine();

            if(command.equalsIgnoreCase("exit")){
                System.out.println("종료합니다.");
                break;
            }

            if(command.startsWith("new")){
                processNewCommand(command.split(" "));
                continue;
            }else if(command.startsWith("change")){
                processChangeCommand(command.split(" "));
                continue;
            }
            printHelp();
        }
    }

    private static Assembler assembler=new Assembler();

    private static void processNewCommand(String[] args){
        if(args.length!=5){
            printHelp();
            return;
        }

        MemberRegisterService regSvc=assembler.getMemberRegisterService();
        RegisterRequest req=new RegisterRequest();
        req.setEmail(args[1]);
        req.setName(args[2]);
        req.setPassword(args[3]);
        req.setConfirmPassword(args[4]);

        if(!req.isPasswordEqualToConfirmPassword()){
            System.out.println("암호와 확인이 일치하지 않습니다.\n");
            return ;
        }

        try{
            regSvc.regist(req);
            System.out.println("등록했습니다.\n");
        }catch (DuplicateMemberException e){
            System.out.println("이미 존재하는 이메일 입니다.");
        }
    }

    private static void processChangeCommand(String[] args){
        if(args.length!=4){
            printHelp();
            return;
        }

        ChangePasswordService changePwdSvc=assembler.getChangePasswordService();
        try{
            changePwdSvc.changePassword(args[1],args[2],args[3]);
            System.out.println("암호를 변경했습니다\n");
        }catch (MemberNotFoundException e){
            System.out.println("존재하지 않는 이메일 입니다.\n");
        }catch (WrongIdPasswordException e){
            System.out.println("이메일과 암호가 일치하지 않습니다.");
        }
    }

    private static void printHelp(){
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하시오.");
        System.out.println("<명령어 사용법>");
        System.out.println("new 이메일 이름 암호 암호확인");
        System.out.println("change 이메일 현재비번 변경비번");
        System.out.println();
    }
}




