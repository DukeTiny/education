package com.woniu;

import com.woniu.Bean.*;
import com.woniu.dao.*;

import java.lang.reflect.Field;
import java.util.List;

public class Test
{

    /* 测试SysUserDAO
    public static void main(String[] args) {
        SysUserDAO sd = new SysUserDAO();
        SysUser sysUser = new SysUser(666,"Duke","Tiger","111111","15021932553",new Date());
        SysUser sysUser = new SysUser(777,"Tiger","Duke","111111","15021932553",new Date());
        sd.save(sysUser);
        sd.update(sysUser);
        sd.delete(777);
        List<SysUser> s = sd.findALl();
        for( SysUser ss:s ) {
            System.out.println
            (
                ss.getUserID()+" : "+ss.getUserLoginName()+" : "+ss.getUserRealName()+" : "+
                ss.getUserPassword()+" : "+ss.getUserPhone()+" : "+ss.getUserDate()
            );
        }
        SysUser ss = sd.findOne(777);
        System.out.println
                (
                        ss.getUserID()+" : "+ss.getUserLoginName()+" : "+ss.getUserRealName()+" : "+
                                ss.getUserPassword()+" : "+ss.getUserPhone()+" : "+ss.getUserDate()
                );
    }
*/

    /* 测试ManuInfoDAO
     * public static void main(String[] args) {
        ManuInfoDAO md = new ManuInfoDAO();
        ManuInfo manuInfo = new ManuInfo(222,"BigApple","US","15021932553",new Date());
        md.save(manuInfo);
        md.delete(222);
        List<ManuInfo> manuInfos = md.findALl();
        for ( ManuInfo m:manuInfos ){
            System.out.println(
                m.getManuId()+" : "+m.getManuName()+" : "+m.getManuAddress()+" : "+m.getManuPhone()+" : "+m.getManuDate()
            );
        }
    }*/


    /*  测试GoodsInfoDao
     *  public static void main(String[] args) {
        GoodsInfoDAO gd = new GoodsInfoDAO();
        GoodsInfo goodsInfo = new GoodsInfo(222,"IMac Pro","piece",13800F,2);
        gd.save(goodsInfo);
        gd.update(goodsInfo);
        gd.delete(222);
        List<GoodsInfo> goodsInfos = gd.findALl();
        for( GoodsInfo g:goodsInfos ){
            System.out.println(
                g.getGoodsID()+" : "+g.getGoodsName()+" : "+g.getGoodsUnit()+" : "+g.getGoodsUnitPrice()+" : "+g.getGoodsWeight()
            );
        }
        GoodsInfo g = gd.findOne(111);
        System.out.println(
            g.getGoodsID()+" : "+g.getGoodsName()+" : "+g.getGoodsUnit()+" : "+g.getGoodsUnitPrice()+" : "+g.getGoodsWeight()
        );
    }*/

    /*  测试GoodsManuDAO
     *  public static void main(String[] args) {
        GoodsManuDAO gd = new GoodsManuDAO();
        GoodsManu goodsManu = new GoodsManu(111,111,111);
        gd.save(goodsManu);
        gd.update(goodsManu);
        gd.delete(222);
        List<GoodsManu> goodsManus = gd.findALl();
        for ( GoodsManu g:goodsManus ){
            System.out.print(g.getGMID()+"  ");
            System.out.print(g.getManuID()+"  ");
            System.out.println(g.getGoodsID()+"  ");
        }
    }*/


    /*  测试 CustomerInfoDao
     *  public static void main(String[] args) {
        CustomerInfoDAO cd = new CustomerInfoDAO();
        CustomerInfo customerInfo = new CustomerInfo(222,"大光头","Home","15021932553",new Date());
        cd.save(customerInfo);
        cd.update(customerInfo);
        cd.delete(222);
        List<CustomerInfo> customerInfos = cd.findALl();
        for( CustomerInfo c:customerInfos ){
            System.out.println(
                c.getCustomerID()+" : "+c.getCustomerName()+" : "+c.getCustomerAddress()+" : "+c.getCustomerPhone()+" : "+c.getCustomerDate()
            );
        }
    }*/


    /*  测试CarInfoDAO
     *  public static void main(String[] args) {
        CarInfoDAO cd = new CarInfoDAO();
        CarInfo carInfo = new CarInfo(222,"Audo","EM221","Used",10,new Date(),1);
        cd.save(carInfo);
        cd.update(carInfo);
        cd.delete(222);
        List<CarInfo> carInfos = cd.findALl();
        for( CarInfo c:carInfos ){
            System.out.println(
                c.getCarID()+" : "+c.getCarBrand()+" : "+c.getCarEnginenID()+" : "+c.getCarStatus()+" : "+c.getCarAge()+" : "+c.getCarDate()+" : "+c.getCarFlag()
            );
        }
        }*/

    /*  测试DriverInfoDao
        public static void main(String[] args) {
        DriveInfoDAO dd = new DriveInfoDAO();
        DriverInfo driverInfo = new DriverInfo(22,"小光头",3,"pan.baidu.com",1,new Date());
        dd.save(driverInfo);
        dd.update(driverInfo);
        dd.delete(22);
        List<DriverInfo> driverInfos = dd.findALl();
        for( DriverInfo d:driverInfos ){
            System.out.println(
                d.getDriverID()+" : "+d.getDriverName()+" : "+d.getDriverYear()+" : "+d.getDriverPhoto()+" : "+d.getDriverFlag()+" : "+d.getDriverDate()
            );
        }
    }*/

    /*  测试RouteInfoDAO
     *  public static void main(String[] args) {
        RouteInfoDao rd = new RouteInfoDao();
        RouteInfo routeInfo = new RouteInfo(22,"武汉","西安",900,new Date());
        rd.save(routeInfo);
        rd.update(routeInfo);
        rd.delete(11);
        List<RouteInfo> routeInfos = rd.findALl();
        for ( RouteInfo r:routeInfos ){
            System.out.println(
                r.getRouteID()+" : "+r.getRoutesStart()+" : "+r.getRouteEnd()+" : "+r.getRouteLength()+" : "+r.getRouteDate()
            );
        }
        RouteInfo r = rd.findOne(11);
        System.out.println(r.getRouteID()+" : "+r.getRoutesStart()+" : "+r.getRouteEnd()+" : "+r.getRouteLength()+" : "+r.getRouteDate());
    }*/


    /*  测试OrderInfoDAO
        public static void main(String[] args) {
        OrderInfoDao od = new OrderInfoDao();
        OrderInfo orderInfo = new OrderInfo(22,111,111,22,-10000F,"Waiting",new Date());
        od.save(orderInfo);
        od.update(orderInfo);
        od.delete(22);
        List<OrderInfo> orderInfos = od.findALl();
        for( OrderInfo o:orderInfos ){
            System.out.println(
                o.getOrderID()+" : "+o.getGMID()+" : "+o.getCustomerID()+" : "+o.getRouteID()+" : "+o.getShipmentCost()+" : "+o.getOrderStatus()+" : "+o.getOrderDate()
            );
        }
        OrderInfo o = od.findOne(11);
        System.out.println(o.getOrderID()+" : "+o.getGMID()+" : "+o.getCustomerID()+" : "+o.getRouteID()+" : "+o.getShipmentCost()+" : "+o.getOrderStatus()+" : "+o.getOrderDate());
    }*/


    public static void main(String[] args) {

//        ShipmentInfoDAO sd = new ShipmentInfoDAO();
//        sd.hashCode();
//        ShipmentInfo shipmentInfo = new ShipmentInfo(22,111,11,11,"GOGOGO",new Date());
//        sd.save(shipmentInfo);
//        sd.update(shipmentInfo);
//        sd.delete(22);
//        List<ShipmentInfo> shipmentInfos = sd.findALl();
//        for ( ShipmentInfo s:shipmentInfos ) {
//            System.out.println(
//                s.getShipmentID()+" : "+s.getShipmentID()+" : "+s.getDriverID()+" : "+s.getOrderID()+" : "+s.getShipmentStatus()+" : "+s.getShipmentDate()
//            );
//        }
//        ShipmentInfo s = sd.findOne(11);
//        System.out.println(s.getShipmentID()+" : "+s.getShipmentID()+" : "+s.getDriverID()+" : "+s.getOrderID()+" : "+s.getShipmentStatus()+" : "+s.getShipmentDate());
    }




}
