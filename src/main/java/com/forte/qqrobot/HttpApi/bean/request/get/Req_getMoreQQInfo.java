package com.forte.qqrobot.HttpApi.bean.request.get;

import com.forte.qqrobot.HttpApi.bean.request.ReqBean;

import java.util.List;

/**
 * 「批量取QQ信息」
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/22 17:11
 * @since JDK1.8
 **/
public class Req_getMoreQQInfo implements ReqBean {

    private final String fun = "getMoreQQInfo";

    /** QQ列表，每个QQ用-分开 */
    private String qqList;

    @Override
    public String getFun() {
        return fun;
    }

    public String getQqList() {
        return qqList;
    }

    public void setQqList(String qqList) {
        this.qqList = qqList;
    }

    public void setQqList(String[] qqList) {
        setQqList(String.join("-", qqList));
    }

    public void setQqList(List<String> qqList) {
        setQqList(String.join("-", qqList));
    }
}
