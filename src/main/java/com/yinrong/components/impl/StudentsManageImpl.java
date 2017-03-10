package com.yinrong.components.impl;

import com.yinrong.aop.annotation.YrLog;
import com.yinrong.components.StudentsManage;

/**
 * @author yinrong
 * @className StudentsManageImpl
 * @description ${description}
 * @date 2017/3/9
 */
public class StudentsManageImpl implements StudentsManage {
    @YrLog
    public void save(String name) throws Exception {
        System.out.println("保存");
        Thread.sleep(1000);
    }
    @YrLog
    public void save2(String name) throws Exception {
        System.out.println("保存2");
    }

    public void update(String name) throws Exception {
        System.out.println("修改");
    }
}
