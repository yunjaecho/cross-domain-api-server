package com.yunjae.crossdomainapiserver.domain;

import java.util.List;

public class RequestMessage {
    private String method;
    private String url;
    private List<Header> headers;
    private List<Body> datas;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public List<Body> getDatas() {
        return datas;
    }

    public void setDatas(List<Body> datas) {
        this.datas = datas;
    }
}



