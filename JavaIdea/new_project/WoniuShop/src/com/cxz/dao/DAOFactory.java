package com.cxz.dao;

public class DAOFactory {

    public static IDeliveryAddressDAO getDeliveryAddressDAOImpl(){
        return new DeliveryAddressDAOImpl();
    }
    public static IGoodsDAO getGoodsDAOImpl(){
        return new GoodsDAOImpl();
    }
    public static IOrderDAO getOrderDAOImpl(){
        return new OrderDAOImpl();
    }
    public static IOrderItemDAO getOrderItemDAOImpl(){
        return new OrderItemDAOImpl();
    }
    public static IRoleDAO getRoleDAOImpl(){
        return new RoleDAOImpl();
    }
    public static ITypeDAO getTypeDAOImpl(){
        return new TypeDAOImpl();
    }
    public static IUserLoginDAO getUserLoginDAOImpl(){
        return new UserLoginDAOImpl();
    }

}
