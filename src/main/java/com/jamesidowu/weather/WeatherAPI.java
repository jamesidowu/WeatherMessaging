/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jamesidowu.weather;

import java.text.DecimalFormat;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;

/**
 *
 * @author jamesidowu
 */

public class WeatherAPI {
    public final static String CELSIUS = "\u00B0C";
    
    
    private final OWM owm;
    private final CurrentWeather cwd;
    private final String breakLine = "---------------------------" + "\n";
    
    
    
    public WeatherAPI(OWM owm, CurrentWeather cwd){
        this.owm = owm;
        this.cwd = cwd;
    }
    
    public String welcomeMessage(){
        return "This is your daily Weather Message" + "\n";
    }
    
    public String getCityName(){
        if (cwd.hasRespCode() && cwd.getRespCode() == 200) {
        return "City: " + this.cwd.getCityName() + "\n";
        }
        return "No info returned";
    }
    
    public String printTempHighs(){
        if (cwd.getMainData() != null){
          double tempInCelsius =  this.cwd.getMainData().getTempMax() - 273.15;
          DecimalFormat df = new DecimalFormat(".#");
          
          
        return "Highs of "+ df.format(tempInCelsius) + CELSIUS +  "\n";
        } else {
            return "No high temperature information.";
        }
    }
    
    public String printTempLows(){
        if (cwd.hasRespCode() && cwd.getRespCode() == 200) {
        double tempInCelsius =  this.cwd.getMainData().getTempMin() - 273.15;

            DecimalFormat df = new DecimalFormat(".#");
        return "Lows of " + df.format(tempInCelsius) + CELSIUS +"\n";
        }
        return "No low temperature information.";
    }
    
     public String printPrecipitation(){
        if (this.cwd.hasRainData()){
            return "There is " + this.cwd.getRainData().getPrecipVol3h() + "\n";
        } else {
            return "Currently there is no precipitation information.";
        }  
    }
    
    public String weatherMessage(){
       
        return welcomeMessage() + breakLine + getCityName() + printTempHighs()+ printTempLows() + printPrecipitation();
    }
}
