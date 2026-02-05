package com.ll.wiseSaying;

import com.ll.global.AppContext;
import com.ll.global.Rq;
import com.ll.system.controller.SystemController;
import com.ll.wiseSaying.controller.WiseSayingController;
import com.ll.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    //메서드에서 공유하기 위해서 객체의 전역변수로 바꿔준다.

    private Scanner sc = new Scanner(System.in);
    private int last_cnt = 0;
    //객체 인스턴스 생성
    //추가 리스트로 생성함
    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private SystemController systemController = AppContext.systemController;
    private WiseSayingController wiseSayingController = AppContext.wiseSayingController;


    public void run() {
        //스캐너를 이용하여, 키보드에 입력을 받는다.
        //1단계
        System.out.println("== 명언 탭 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            Rq rq = new Rq(cmd); //cmd 분석 객체

            String action = rq.getAction();

            if (action.equals("종료")) {
                systemController.exit();
                break;
            }
            //2단계 (등록)
            else if (action.equals("등록")) {
                wiseSayingController.actionWrite();
            } else if (action.equals("목록")) {
                wiseSayingController.actionShow();
            } else if (action.startsWith("삭제")) {
                wiseSayingController.actionDelete(rq);
            } else if (action.startsWith("수정")) {
                wiseSayingController.actionModify(rq);
            }
        }
    }}

