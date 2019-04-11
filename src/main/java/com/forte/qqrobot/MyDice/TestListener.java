package com.forte.qqrobot.MyDice;

import com.forte.qqrobot.anno.Filter;
import com.forte.qqrobot.anno.Listen;
import com.forte.qqrobot.beans.msgget.MsgGroup;
import com.forte.qqrobot.beans.types.KeywordMatchType;
import com.forte.qqrobot.beans.types.MsgGetTypes;
import com.forte.qqrobot.socket.QQWebSocketMsgSender;
import com.forte.qqrobot.utils.CQCodeUtil;

public class TestListener {
    public class testListener {
        @Listen(MsgGetTypes.msgGroup)
        @Filter(value = "你好", at = true, keywordMatchType = KeywordMatchType.TRIM_REGEX)
        public boolean start(MsgGroup msgGroup, QQWebSocketMsgSender sender, CQCodeUtil cqCodeUtil) {
            sender.sendGroupMsg(msgGroup.getFromGroup(), "大家好~");
            return true;
        }
    }
}
