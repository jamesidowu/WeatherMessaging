/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jamesidowu.weather;

import com.messagebird.exceptions.GeneralException;
import com.messagebird.exceptions.UnauthorizedException;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;

/**
 *
 * @author jamesidowu
 */
public class WeatherMain {
    
    final static String myPhoneNumber = "+447900982740";
    
     public static void main(String[] args)
            throws APIException, UnauthorizedException, GeneralException {
         MessageAPI message = new MessageAPI();
         OWM myOwm = new OWM("0e47838bfbc2fe81613c58a14decb7c1");
         CurrentWeather myCwd = myOwm.currentWeatherByCityName("London");
         WeatherAPI weather = new WeatherAPI(myOwm, myCwd);
         message.getMessaging(myPhoneNumber, weather.weatherMessage());  
    }
}