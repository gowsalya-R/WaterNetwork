package com.example.gowsalya.waterdistributionlog.entities;

import java.util.Date;

/**
 * Created by Gowsalya on 13/6/16.
 */
public class PumpDetails{

    // This PumpDetails.java stores the details of single pump

    // What information is collected is stored in the following variables

    private double mainSumpLevel;
    private Date pumpOnTime;
    private Date pumpOffTime;
    private double overHeadTankLevelBeforeFilling;
    private double overHeadTankLevelAfterFilling;
    private Date sumpOnTime;
    private Date sumpOffTime;
    public double getMainSumpLevel() {
        return mainSumpLevel;
    }

    public void setMainSumpLevel(double mainSumpLevel) {
        this.mainSumpLevel = mainSumpLevel;
    }

    public Date getPumpOnTime() {
        return pumpOnTime;
    }

    public void setPumpOnTime(Date pumpOnTime) {
        this.pumpOnTime = pumpOnTime;
    }

    public Date getPumpOffTime() {
        return pumpOffTime;
    }

    public void setPumpOffTime(Date pumpOffTime) {
        this.pumpOffTime = pumpOffTime;
    }

    public double getOverHeadTankLevelBeforeFilling() {
        return overHeadTankLevelBeforeFilling;
    }

    public void setOverHeadTankLevelBeforeFilling(double overHeadTankLevelBeforeFilling) {
        this.overHeadTankLevelBeforeFilling = overHeadTankLevelBeforeFilling;
    }

    public double getOverHeadTankLevelAfterFilling() {
        return overHeadTankLevelAfterFilling;
    }

    public void setOverHeadTankLevelAfterFilling(double overHeadTankLevelAfterFilling) {
        this.overHeadTankLevelAfterFilling = overHeadTankLevelAfterFilling;
    }

    public Date getSumpOnTime() {
        return sumpOnTime;
    }

    public void setSumpOnTime(Date sumpOnTime) {
        this.sumpOnTime = sumpOnTime;
    }

    public Date getSumpOffTime() {
        return sumpOffTime;
    }

    public void setSumpOffTime(Date sumpOffTime) {
        this.sumpOffTime = sumpOffTime;
    }
}