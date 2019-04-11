package com.forte.qqrobot.MyDice;

import com.forte.qqrobot.LinkConfiguration;
import com.forte.qqrobot.RobotApplication;
import com.forte.qqrobot.anno.Filter;
import com.forte.qqrobot.anno.Listen;
import com.forte.qqrobot.beans.msgget.MsgGroup;
import com.forte.qqrobot.beans.types.KeywordMatchType;
import com.forte.qqrobot.beans.types.MsgGetTypes;
import com.forte.qqrobot.socket.QQWebSocketMsgSender;
import com.forte.qqrobot.utils.CQCodeUtil;

public class MyDiceTest extends RobotApplication {
    @Override
    public void before(LinkConfiguration configuration) {
        //配置装有LEMOC插件的服务器IP地址，不配置则默认为"localhost"
        configuration.setLinkIp("127.0.0.1");
        //配置LEMOC插件配置的端口号，不配置默认为25303
        configuration.setPort(25303);
        //*可用，推荐(因为比较方便)：使用包扫描加载监听器
        configuration.scannerListener("com.forte.qqrobot.MyDice");
//        //*可用，推荐(因为比较方便)：使用包扫描加载初始化监听器
//        configuration.scannerInitListener("com.test.initlistener");
        //*可选，使用的是HTTP API插件获取：设置本机QQ昵称，如果不配置默认为空，在连接后框架将会尝试自动获取，假如获取失败且未手动配置则会无法正常获取本机QQ的昵称
        configuration.setLocalQQNick("坂本酱");
    }

    @Override
    public void after(CQCodeUtil cqCodeUtil, QQWebSocketMsgSender sender) {

    }

    @Override
    public String author() {
        return null;
    }

    public class TestListener {
        @Listen(MsgGetTypes.msgGroup)
        @Filter(value = "你好", at = true, keywordMatchType = KeywordMatchType.TRIM_REGEX)
        public boolean start(MsgGroup msgGroup, QQWebSocketMsgSender sender, CQCodeUtil cqCodeUtil) {
            sender.sendGroupMsg(msgGroup.getFromGroup(), "大家好~");
            return true;
        }
    }
}
