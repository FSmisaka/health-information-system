package com.org.factory;

import com.org.dao.IHealthDataDAO;
import com.org.dao.impl.*;
import com.org.dao.proxy.HealthDataDAOProxy;
import com.org.dbc.DatabaseConnection;

import java.sql.SQLException;

public class DAOFactory {
    public static IHealthDataDAO getIBloodDAOInstance() throws SQLException, ClassNotFoundException {
        return new HealthDataDAOProxy(new BloodPressureDAOImpl(new DatabaseConnection().getConnection()));
    }
    public static IHealthDataDAO getIHeartRateDAOInstance() throws SQLException, ClassNotFoundException {
        return new HealthDataDAOProxy(new HeartRateDAOImpl(new DatabaseConnection().getConnection()));
    }
    public static IHealthDataDAO getIHeightDAOInstance() throws SQLException, ClassNotFoundException {
        return new HealthDataDAOProxy(new HeightDAOImpl(new DatabaseConnection().getConnection()));
    }
    public static IHealthDataDAO getIWeightDAOInstance() throws SQLException, ClassNotFoundException {
        return new HealthDataDAOProxy(new WeightDAOImpl(new DatabaseConnection().getConnection()));
    }
    public static IHealthDataDAO getIStepsDAOInstance() throws SQLException, ClassNotFoundException {
        return new HealthDataDAOProxy(new StepsDAOImpl(new DatabaseConnection().getConnection()));
    }
    public static IHealthDataDAO getIBloodSugarDAOInstance() throws SQLException, ClassNotFoundException {
        return new HealthDataDAOProxy(new BloodSugarDAOImpl(new DatabaseConnection().getConnection()));
    }
    public static IHealthDataDAO getIBloodOxygenDAOInstance() throws SQLException, ClassNotFoundException {
        return new HealthDataDAOProxy(new BloodOxygenDAOImpl(new DatabaseConnection().getConnection()));
    }
}
