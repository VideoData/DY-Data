package com.lida.dy.schedle.ippool;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/28 0028 18:07
 * @Version: 1.0
 */
public class IPBean {
    public static final int TYPE_HTTP = 0;
    public static final int TYPE_HTTPS = 1;

    private String ip;
    private int port;
    private int type;

    public IPBean(IPBean bean){
        ip = bean.getIp();
        port = bean.getPort();
        type = bean.getType();
    }

    public IPBean(String ip, int port, int type) {
        this.ip = ip;
        this.port = port;
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
