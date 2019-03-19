package com.forte.qqrobot.socket;

import com.forte.qqrobot.ResourceDispatchCenter;
import com.forte.qqrobot.beans.inforeturn.*;

/**
 * QQWebsocket信息发送器
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @date Created in 2019/3/8 18:32
 * @since JDK1.8
 **/
public class QQWebSocketMsgSender {

    /** 客户端连接client对象 */
    private final QQWebSocketClient client;

    /** 响应信息字符串生成器 MsgCreator */
    private final QQWebSocketMsgCreator creator;

    /** 私有构造 */
    private QQWebSocketMsgSender(QQWebSocketClient client, QQWebSocketMsgCreator creator){
        this.client = client;
        this.creator = creator;

    }

    /**
     * 工厂方法
     * @return QQWebSocketMsgSender实例对象
     */
    public static QQWebSocketMsgSender of(QQWebSocketClient client){
        return new QQWebSocketMsgSender(client, ResourceDispatchCenter.getQQWebSocketMsgCreator());
    }

    /* ———————————————— 信息发送方法 ———————————————— */

    /**
     * 讨论组消息
     * @param discussid 讨论组
     * @param msg       消息
     */
    public void sendDisGroupMsg(String discussid, String msg){
        send(creator.getResponseJson_sendDisGroupMsg(discussid, msg));
    }

    /**
     * 群消息
     * @param groupid   群号
     * @param msg       消息
     */
    public void sendGroupMsg(String groupid, String msg){
        send(creator.getResponseJson_sendGroupMsg(groupid, msg));
    }

    /**
     * 私信消息
     * @param QQID  qq号
     * @param msg   消息
     */
    public void sendMsgPrivate(String QQID, String msg){
        send(creator.getResponseJson_sendMsgPrivate(QQID, msg));
    }

    /**
     * 赞
     * @param QQID qq号
     */
    public void sendPraise(String QQID){
        send(creator.getResponseJson_sendPraise(QQID));
    }

    /**
     * 设置全群禁言
     * @param QQID      qq号
     * @param groupid   群号
     * @param enableban 是否开启禁言
     */
    public void setAllGroupBanned(String QQID, String groupid, String enableban){
        send(creator.getResponseJson_setAllGroupBanned(QQID, groupid, enableban));
    }

    /**
     * 设置匿名群员禁言
     * @param groupid   群号
     * @param duration  时间，单位 秒
     * @param anomymous 匿名群员名称，大概
     */
    public void setAnoGroupMemberBanned(String groupid, Long duration, String anomymous){
        send(creator.getResponseJson_setAnoGroupMemberBanned(groupid, duration, anomymous));
    }

    /**
     * 讨论组退出
     * @param discussid 讨论组id
     */
    public void setDisGroupExit(String discussid){
        send(creator.getResponseJson_setDisGroupExit(discussid));
    }

    /**
     * 好友添加请求
     * @param responseoperation
     * @param remark
     * @param responseflag
     */
    public void setFriendAddRequest(String responseoperation, String remark, String responseflag){
        send(creator.getResponseJson_setFriendAddRequest(responseoperation, remark, responseflag));
    }

    /**
     * 设置群管理员
     * @param QQID      qq号
     * @param groupid   群号
     * @param setadmin  是否设置为管理员
     */
    public void setGroupAdmin(String QQID, String groupid, Boolean setadmin){
        send(creator.getResponseJson_setGroupAdmin(QQID, groupid, setadmin));
    }

    /**
     * 群匿名设置
     * @param groupid           群号
     * @param enableanomymous   是否开启群匿名
     */
    public void setGroupAno(String groupid, Boolean enableanomymous){
        send(creator.getResponseJson_setGroupAno(groupid, enableanomymous));
    }

    /**
     * 置群退出(出于安全起见，该权限没有开启)
     * @param groupid   群号
     * @param isdismiss 是否退出
     */
    public void setGroupExit(String groupid, Boolean isdismiss){
        send(creator.getResponseJson_setGroupExit(groupid, isdismiss));
    }

    /**
     *  置群添加请求
     *  参数意义暂且不明
     * @param requesttype
     * @param responseoperation
     * @param reason
     * @param responseflag
     */
    public void setGroupJoinResquest(String requesttype, String responseoperation, String reason, String responseflag){
        send(creator.getResponseJson_setGroupJoinResquest(requesttype, responseoperation, reason, responseflag));
    }

    /**
     * 置群员禁言
     * @param QQID      qq号
     * @param groupid   群号
     * @param duration  禁言时间，单位为秒
     */
    public void setGroupMemberBanned(String QQID, String groupid, Long duration){
        send(creator.getResponseJson_setGroupMemberBanned(QQID, groupid, duration));
    }

    /**
     * 置群成员名片
     * @param QQID      qq号
     * @param groupid   群号
     * @param newcard   新名片
     */
    public void setGroupMemberCard(String QQID, String groupid, String newcard){
        send(creator.getResponseJson_setGroupMemberCard(QQID, groupid, newcard));
    }

    /**
     * 置群员移除
     * @param QQID              移除的qq号
     * @param groupid           群号
     * @param rejectaddrequest  是否拒绝添加请求
     */
    public void setGroupMemberRemove(String QQID, String groupid, Boolean rejectaddrequest){
        send(creator.getResponseJson_setGroupMemberRemove(QQID, groupid, rejectaddrequest));
    }

    /**
     *  置群成员专属头衔
     * @param QQID              qq号
     * @param groupid           群号
     * @param duration          设置时间，单位大概是秒
     * @param newspecialtitle   专属头衔
     */
    public void setGroupMemberSpecialTitle(String QQID, String groupid, Long duration, String newspecialtitle){
        send(creator.getResponseJson_setGroupMemberSpecialTitle(QQID, groupid, duration, newspecialtitle));
    }


    /* ———————————————— 获取信息 ———————————————— */

    /**
     * 获取全部群信息
     * @param QQID 标记用QQ号
     * @return 群信息的列表
     */
    public ReturnLoginInGroups getLoginInGroups(String QQID){
        int act = 25305;
        send(creator.getResponseJson_InfoForLoginInGroups(QQID));
        //获取返回值
        QQWebSocketInfoReturnManager manager = getSoocketInfoReturnManager();
        //标记一次更新
        manager.send(act);

        return manager.get(act, ReturnLoginInGroups.class);
    }

    /**
     * 获取某个群员的信息
     * @param groupid   群id
     * @param QQID      qq号
     * @param nocache   1 或 0之类的
     * @return 某个群员的信息
     */
    public ReturnGroupMember getGroupMember(String groupid, String QQID, String nocache){
        int act = 25303;
        send(creator.getResponseJson_InfoGroupMember(groupid, QQID, nocache));
        //获取返回值
        QQWebSocketInfoReturnManager manager = getSoocketInfoReturnManager();
        //标记一次更新
        manager.send(act);

        return manager.get(act, ReturnGroupMember.class);

    }

    /**
     * 获取登录账号的昵称
     * @return 昵称
     */
    public ReturnLoginNick getLoginNick(){
        int act = 25302;
        send(creator.getResponseJson_InfoLoginNick());
        //获取返回值
        QQWebSocketInfoReturnManager manager = getSoocketInfoReturnManager();
        manager.send(act);

        return manager.get(act, ReturnLoginNick.class);
    }

    /**
     * 获取当前登录账号的qq号
     * @return 当前登录账号的qq号
     */
    public ReturnLoginQQ getLoginQQ(){
        int act = 25301;
        send(creator.getResponseJson_InfoLoginQQ());
        //获取返回值
        QQWebSocketInfoReturnManager manager = getSoocketInfoReturnManager();
        manager.send(act);

        return manager.get(act, ReturnLoginQQ.class);
    }

    /**
     * 获取陌生人信息
     * @return
     */
    public ReturnStranger getStrangerInfo(String QQID, String nocache){
        int act = 25304;
        send(creator.getResponseJson_InfoStranger(QQID, nocache));
        //获取返回值
        QQWebSocketInfoReturnManager manager = getSoocketInfoReturnManager();
        manager.send(act);

        return manager.get(act, ReturnStranger.class);
    }



    /**
     * 发送消息 - 在一条新的线程中发送消息
     */
    public void send(String text){
        ResourceDispatchCenter.getThreadPool().execute(() -> client.send(text));
    }


    private QQWebSocketInfoReturnManager getSoocketInfoReturnManager(){
        return ResourceDispatchCenter.getQQWebSocketInfoReturnManager();
    }

}
