package com.ll.wiseSaying.repository;

import com.ll.wiseSaying.entity.WiseSaying;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WiseSayingRepository {

    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int last_cnt = 0;


    public WiseSaying findById(int id){
        int ModifyTarget = id;

        int findIdx =findIndexById(id);
        if (findIdx==-1){
            return null;
        }
        else{
            return wiseSayings.get(findIdx);
        }
    }

    private int findIndexById(int id){

        return IntStream
                .range(0,wiseSayings.size())
                .filter(i->wiseSayings.get(i).getCnt()==id)
                .findFirst()
                .orElse(-1);

    }

    public List<WiseSaying> findList(){
        //리스트 버전
        List<WiseSaying> wiseSayingList = new ArrayList<>();
        for (WiseSaying wiseSaying:wiseSayings.reversed()){
            wiseSayingList.add(wiseSaying);
        }

        return wiseSayingList;
    }

    public boolean delete(int id){
        return wiseSayings.removeIf((wiseSaying)-> wiseSaying.getCnt() == id);

    }

    public WiseSaying save(WiseSaying wiseSaying){
        //객체 상태 통째로 넘기기
        //새로 저장하라 id==0이면 새로운 wiseSaying 등록
        if (wiseSaying.getCnt()==0){
            wiseSaying.setCnt(++last_cnt);

            wiseSaying.setCreateDate(LocalDateTime.now());
            wiseSaying.setModifyDate(LocalDateTime.now());
            wiseSayings.add(wiseSaying);

        }
        else{
            wiseSaying.setModifyDate(LocalDateTime.now());
        }
        return wiseSaying;
        //수정 : 현재 상태에서는 수정 코드 필요 없기 때문에 일단은 이렇게 작성
    }

}
