package com.ll.global;

import com.ll.system.controller.SystemController;
import com.ll.wiseSaying.controller.WiseSayingController;
import com.ll.wiseSaying.repository.WiseSayingRepository;
import com.ll.wiseSaying.service.WiseSayingService;

public class AppContext {

    //순서 중요하다

    public static WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    public static WiseSayingService wiseSayingService = new WiseSayingService();
    public static SystemController systemController = new SystemController();
    public static WiseSayingController wiseSayingController = new WiseSayingController();


}
