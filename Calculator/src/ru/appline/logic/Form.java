package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Form implements Serializable {

    private static Form instace = new Form();

    private Map<Integer ,Calculator>Form;

    public static Form getInstance(){
        return instace;
    }
    private Form(){
        Form=new HashMap<>();
        Form.put(1,new Calculator(1,2,"+"));
    }
    public void add(Calculator calculator, int id){
        Form.put(id,calculator);
    }
    public Map<Integer,Calculator> getFormList(){
        return Form;
    }

}

