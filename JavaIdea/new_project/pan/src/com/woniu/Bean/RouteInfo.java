package com.woniu.Bean;

import java.util.Date;

public class RouteInfo {

    private Integer routeID;
    private String routesStart;
    private String routeEnd;
    private Integer routeLength;
    private Date routeDate;

    public RouteInfo() {}

    public RouteInfo(Integer routeID, String routesStart, String routeEnd, Integer routeLength, Date routeDate) {
        this.routeID = routeID;
        this.routesStart = routesStart;
        this.routeEnd = routeEnd;
        this.routeLength = routeLength;
        this.routeDate = routeDate;
    }

    public Integer getRouteID() {
        return routeID;
    }

    public void setRouteID(Integer routeID) {
        this.routeID = routeID;
    }

    public String getRoutesStart() {
        return routesStart;
    }

    public void setRoutesStart(String routesStart) {
        this.routesStart = routesStart;
    }

    public String getRouteEnd() {
        return routeEnd;
    }

    public void setRouteEnd(String routeEnd) {
        this.routeEnd = routeEnd;
    }

    public Integer getRouteLength() {
        return routeLength;
    }

    public void setRouteLength(Integer routeLength) {
        this.routeLength = routeLength;
    }

    public Date getRouteDate() {
        return routeDate;
    }

    public void setRouteDate(Date routeDate) {
        this.routeDate = routeDate;
    }
}
