package com.org.controller;

import com.org.factory.DAOFactory;
import com.org.vo.HealthData;

import java.util.ArrayList;

public class PreparedSuggestion {
    public static String createSuggestion(String healthData, int id) throws Exception {
        String ret = "今天你运动了吗?";
        switch(healthData) {
            case "weight":
                ArrayList<HealthData> weightList = DAOFactory.getIWeightDAOInstance().dataTrend(id);
                ArrayList<HealthData> heightList = DAOFactory.getIHeightDAOInstance().dataTrend(id);
                if(!weightList.isEmpty()) {
                    // 处理成int 方便后续的选择控制
                    double weight = weightList.get(0).getData();
                    double height = heightList.get(0).getData()/100;
                    int bmi = (int)(weight/(height*height));
                    if(bmi >= 24) {
                        ret = "最近称坏了好几台秤，是不是你干的？";
                    } else if(bmi < 18) {
                        ret = "你是故意的吧？这么轻让我显得重了好几斤！";
                    } else {
                        ret = "体重？完美得像数学公式！";
                    }
                }
                break;
            case "steps":
                ArrayList<HealthData> stepsList = DAOFactory.getIStepsDAOInstance().dataTrend(id);
                if(!stepsList.isEmpty()) {
                    int steps = (int)stepsList.get(0).getData();
                    if(steps >= 10000) {
                        ret = "今天地球的自转是不是靠你推动的？";
                    } else {
                        ret = "你的步数，连我的计算器都不屑于计算！";
                    }
                }
                break;
            case "bloodOxygen":
                ArrayList<HealthData> bloodOxygenList = DAOFactory.getIBloodOxygenDAOInstance().dataTrend(id);
                if(!bloodOxygenList.isEmpty()) {
                    int oxygen = (int)bloodOxygenList.get(0).getData();
                    if(oxygen >= 99) {
                        ret = "地球上的氧气都被你承包了！";
                    } else {
                        ret = "空气可是免费的，多吸几口！";
                    }
                }
                break;
            case "bloodSuagr":
                ArrayList<HealthData> bloodSugarList = DAOFactory.getIBloodSugarDAOInstance().dataTrend(id);
                if(!bloodSugarList.isEmpty()) {
                    int sugar = (int)bloodSugarList.get(0).getData();
                    if(sugar < 4) {
                        ret = "血糖有些低，请避免长时间空腹，低升糖指数！";
                    } else if (sugar > 6) {
                        ret = "血糖有些高，请控制糖分摄入，适当运动！";
                    } else {
                        ret = "你的血糖像你的性格，恰到好处，甜得刚刚好！";
                    }
                }
                break;
            case "bloodPressure":
                ArrayList<HealthData> bloodPressureList = DAOFactory.getIBloodDAOInstance().dataTrend(id);
                if(!bloodPressureList.isEmpty()) {
                    int pressure = (int)bloodPressureList.get(0).getData();
                    if(pressure < 60) {
                        ret = "血压有些低，保证足够的微量元素摄入，多休息！";
                    } else if (pressure > 140) {
                        ret = "血压有些高，低盐低糖多运动！";
                    } else {
                        ret = "你的血压像你的性格，恰到好处～";
                    }
                }
                break;
            default:
                break;
        }
        return ret;
    }
}
