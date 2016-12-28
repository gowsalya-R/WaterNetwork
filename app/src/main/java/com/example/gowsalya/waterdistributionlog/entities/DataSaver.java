package com.example.gowsalya.waterdistributionlog.entities;

import java.util.HashMap;

/** * Created by gowsalya on 15/3/16.**/

/** In this DataSaver.Java,Singleton concept is used **/

public class DataSaver {

    /** DataSaver stores the data for all the pumps in hash map **/

    /** ourInstance is an object/instance of class DataSaver and it is also ensuring only one instance of the singleton class ie DataSaver Class **/

    private static DataSaver ourInstance = new DataSaver();

    /** This is getInstance method and static in order for other components not to create other object **/

    public static DataSaver getInstance() {
        return ourInstance;/** Method has return type **/
    }


    /** This is constructor, constructor has same name of class (eg : DataSaver).It invokes when an object of class is created and can't called explicitly **/
    /**  It constructs the values i.e. provides data for the object that is why it is known as constructor.
     * constructor of all the class should be private **/

    private DataSaver() {
        /** A constructor is declared like a method but has no return type  **/
    }

    /** The hash map used to map the pump name with its pump details and it stores it in the variable pumpDetails **/

    private final HashMap<String, PumpDetails> pumpDetails = new HashMap<>();


    public void put(String pumpName, PumpDetails details) {
        pumpDetails.put(pumpName, details);
    }

}
