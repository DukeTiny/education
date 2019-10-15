package com.cxz.dao;

import com.cxz.dao.implement.ProductDAOImpl;
import com.cxz.dao.implement.ProductTypeDAOImpl;
import com.cxz.dao.implement.StockDAOImpl;
import com.cxz.dao.implement.UserInformationDAOImpl;
import com.cxz.dao.interFace.IProductDAO;
import com.cxz.dao.interFace.IProductTypeDAO;
import com.cxz.dao.interFace.IStockDAO;
import com.cxz.dao.interFace.IUserInformationDAO;

public class DAOFactory {

    public static IProductDAO getProductDAO(){
        return new ProductDAOImpl();
    }
    public static IProductTypeDAO getProductTypeDAO(){
        return new ProductTypeDAOImpl();
    }
    public static IStockDAO getStockDAO(){
        return new StockDAOImpl();
    }
    public static IUserInformationDAO getUserInfoDAO(){
        return new UserInformationDAOImpl();
    }


}
