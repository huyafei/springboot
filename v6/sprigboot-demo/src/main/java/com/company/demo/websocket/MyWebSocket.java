package com.company.demo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/3/18 16:03
 */
@Component
@ServerEndpoint("/websocket/{name}")
public class MyWebSocket {
    static Logger logger = LoggerFactory.getLogger(MyWebSocket.class);
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    /**
     * 与某个客户端的连接对话，需要通过它来给客户端发送消息
     */
    private Session session;
    /**
     * 标识当前连接客户端的用户名
     */
    private String name;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();


    //建立连接
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "name") String name) throws IOException {
        System.out.println("OnOpen");

        this.session = session;
        this.name=name;
        webSocketSet.add(this);//加入set中
        sendMessageTo(this.session, "服务器/&:连接成功");
        System.out.println(name);
        logger.info("[WebSocket] 连接成功，当前连接人数为：={}", webSocketSet.size());
    }

    //接受消息
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("OnMessage");
        System.out.println(message);
        sendGroupMessageTo(message);
    }

    //处理连接关闭
    @OnClose
    public void onClose() {
        System.out.println("OnClose");
        webSocketSet.remove(this);
        logger.info("[WebSocket] 退出成功，当前连接人数为：={}", webSocketSet.size());
    }

    //处理错误
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("OnError");
        logger.error("发生错误：{}，Session ID： {}", error.getMessage(), session.getId());
        error.printStackTrace();
    }

    public void sendMessageTo(Session session, String msg) throws IOException {
        session.getBasicRemote().sendText(msg);
    }

    //群发
    public void sendGroupMessageTo(String msg) {
        for (MyWebSocket item : webSocketSet) {
            try {
                item.sendMessageTo(item.session, name+"/&:"+msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
