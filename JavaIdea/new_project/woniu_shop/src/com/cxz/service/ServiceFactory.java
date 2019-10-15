package com.cxz.service;

public class ServiceFactory {

    public static IProductService getProductService(){
        return new ProductServiceImpl();
    }

    public static IProductTypeService getProductTypeService(){
        return new ProductTypeServiceImpl();
    }

    public static IStockService getStockService(){
        return new StockServiceImpl();
    }

    public static IUserService getUserInfoService(){
        return new UserServiceImpl();
    }

}
