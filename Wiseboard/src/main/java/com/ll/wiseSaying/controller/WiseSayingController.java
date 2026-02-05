package com.ll.wiseSaying.controller;

import com.ll.global.AppContext;
import com.ll.global.Rq;
import com.ll.wiseSaying.entity.WiseSaying;
import com.ll.wiseSaying.service.WiseSayingService;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private Scanner sc = new Scanner(System.in);
    private WiseSayingService wiseSayingService = AppContext.wiseSayingService;


    public void actionModify(Rq rq){
        int id = rq.getParamInt("id",-1);

        if (id ==-1){
            System.out.println("아이디를 제대로 입력해주세요");
            return;
        }
        WiseSaying wiseSaying= wiseSayingService.findById(id);
        if (wiseSaying==null){
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        //사용자 상호작용만 따로 뺀다.
        System.out.print("명언(기존) : %s\n".formatted(wiseSaying.getContent()));
        System.out.print("명언 : ");
        String new_content = sc.nextLine();
        System.out.print("작가(기존) : %s\n".formatted(wiseSaying.getAuthor()));
        System.out.print("작가 : ");
        String new_author = sc.nextLine();

        wiseSayingService.modify(wiseSaying,new_content,new_author);
    }



    public void actionDelete(Rq rq) {

        //String num = cmd.substring(6,cmd.length());
        int id = rq.getParamInt("id",-1);
        if (id==-1){
            System.out.println("아이디를 제대로 입력해주세요");
            return;
        }
        Boolean answer =wiseSayingService.delete(id);

        if (answer == true){
            System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
        }
        else{
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

    }

    //목록
    public void actionShow() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List<WiseSaying> wiseSayingList = wiseSayingService.findList();
        //리스트 버전

        for (WiseSaying wiseSaying : wiseSayingList){
            System.out.printf("%d / %s / %s \n",wiseSaying.getCnt(),wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }

    public void actionWrite() {

        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        WiseSaying wiseSaying = wiseSayingService.write(content,author);
        System.out.println(wiseSaying.getCnt()+"번이 등록되었습니다.");

    }

    public void actionList(){
        System.out.println("번호/작가/명언/작성일/수정일");
        System.out.println("----------------------------------");
        List<WiseSaying> foundedWiseSaying = wiseSayingService.findList();


        for (WiseSaying wiseSaying: foundedWiseSaying){
            System.out.printf("%d / %s / %s / %s \n",wiseSaying.getCnt(),
                    wiseSaying.getAuthor(), wiseSaying.getContent(),
                    wiseSaying.getCreateDate(),wiseSaying.getModifyDate());
        }
    }



}








